package me.flyray.rbac.controller.crm;

import me.flyray.rbac.annotation.SysLog;
import me.flyray.rbac.controller.AbstractController;
import me.flyray.rbac.utils.PageUtils;
import me.flyray.rbac.utils.R;
import me.flyray.rest.api.ApiProvider;
import me.flyray.rest.model.Parameter;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ${tianlin} on 2017-11-03.
 */
@RestController
@RequestMapping("crm/customerRole")
public class CustomerRoleController extends AbstractController {

    private static final Logger logger= LoggerFactory.getLogger(CustomerRoleController.class);

    @Autowired
    private ApiProvider apiProvider;

    /**
     * 所有会员角色列表
     * @param params
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("crm:customerRole:list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Parameter parameter=new Parameter("customerRoleService","queryList");
        Map<String,Object> map=new HashMap<>();
        map.put("customerRoleNo", "");
        parameter.setMap(map);
        List<?> list=apiProvider.execute(parameter).getList();
        int total=list.size();
        PageUtils pageUtils=new PageUtils(list,total,10,1);
        return R.ok().put("page",pageUtils);
    }

    /**
     * 会员角色详情
     * @param id
     * @return
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("crm:customerRole:info")
    public R info(@PathVariable("id") Long id){
        Parameter parameter = new Parameter("customerRoleService", "queryById");
        parameter.setId(id);
        Parameter parameter1=apiProvider.execute(parameter);
        Map<?,?> map1=parameter1.getMap();
       // Map<?,?> map1=apiProvider.execute(parameter).getMap();
        return R.ok().put("CustomerRole",map1);
    }

    @SysLog("保存会员角色信息")
    @RequestMapping("/save")
    @RequiresPermissions("crm:customerRole:save")
    public R save(@RequestBody Map<String, Object> params){
        Parameter parameter=new Parameter("customerRoleService","save");
        Map<String,Object> map=new HashMap<>();
        map.put("roleNo",params.get("roleNo"));
        map.put("roleName",params.get("roleName"));

        parameter.setMap(map);
        apiProvider.execute(parameter);
        return R.ok();
    }

    /**
     * 修改会员角色信息
     * @param params
     * @return
     */
    @SysLog("修改会员角色")
    @RequestMapping("/update")
    @RequiresPermissions("crm:customerRole:update")
    public R update(@RequestBody Map<String, Object> params){
    	logger.info("flyray-operation修改会员角色---请求参数:{}",params);
        Parameter parameter=new Parameter("customerRoleService","update");
        Map<String, Object> map=new HashMap<>();
        map.put("roleNo",params.get("roleNo"));
        map.put("roleName",params.get("roleName"));
        parameter.setMap(map);
        apiProvider.execute(parameter);
        return R.ok();
    }

    @SysLog("删除客户会员")
    @RequestMapping("/delete")
    @RequiresPermissions("crm:customerRole:delete")
    public R delete(@RequestBody Long[] ids){
        Parameter parameter=new Parameter("customerRoleService","deleteBatch");
        Map<String, Object> map=new HashMap<>();
        map.put("ids",ids);
        parameter.setMap(map);
        apiProvider.execute(parameter);
        return R.ok();
    }
}
