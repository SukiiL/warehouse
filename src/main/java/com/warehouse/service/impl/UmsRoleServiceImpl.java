package com.warehouse.service.impl;


import com.warehouse.entity.login.UmsMenu;
import com.warehouse.mapper.UmsRoleDao;
import com.warehouse.service.UmsAdminCacheService;
import com.warehouse.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 后台角色管理Service实现类
 * Created by macro on 2018/9/30.
 */
@Service
public class UmsRoleServiceImpl implements UmsRoleService {
//    @Autowired
//    private UmsRoleMapper roleMapper;
//    @Autowired
//    private UmsRoleMenuRelationMapper roleMenuRelationMapper;
//    @Autowired
//    private UmsRoleResourceRelationMapper roleResourceRelationMapper;
    @Resource
    private UmsRoleDao roleDao;
    @Autowired
    private UmsAdminCacheService adminCacheService;
//    @Override
//    public int create(UmsRole role) {
//        role.setCreateTime(new Date());
//        role.setAdminCount(0);
//        role.setSort(0);
//        return roleMapper.insert(role);
//    }
//
//    @Override
//    public int update(Long id, UmsRole role) {
//        role.setId(id);
//        return roleMapper.updateByPrimaryKeySelective(role);
//    }
//
//    @Override
//    public int delete(List<Long> ids) {
//        UmsRoleExample example = new UmsRoleExample();
//        example.createCriteria().andIdIn(ids);
//        int count = roleMapper.deleteByExample(example);
//        adminCacheService.delResourceListByRoleIds(ids);
//        return count;
//    }
//
//    @Override
//    public List<UmsRole> list() {
//        return roleMapper.selectByExample(new UmsRoleExample());
//    }
//
//    @Override
//    public List<UmsRole> list(String keyword, Integer pageSize, Integer pageNum) {
//        PageHelper.startPage(pageNum, pageSize);
//        UmsRoleExample example = new UmsRoleExample();
//        if (!StringUtils.isEmpty(keyword)) {
//            example.createCriteria().andNameLike("%" + keyword + "%");
//        }
//        return roleMapper.selectByExample(example);
//    }

    @Override
    public List<UmsMenu> getMenuList(Long adminId) {
        return roleDao.getMenuList(adminId);
    }
//
//    @Override
//    public List<UmsMenu> listMenu(Long roleId) {
//        return roleDao.getMenuListByRoleId(roleId);
//    }
//
//    @Override
//    public List<UmsResource> listResource(Long roleId) {
//        return roleDao.getResourceListByRoleId(roleId);
//    }
//
//    @Override
//    public int allocMenu(Long roleId, List<Long> menuIds) {
//        //先删除原有关系
//        UmsRoleMenuRelationExample example=new UmsRoleMenuRelationExample();
//        example.createCriteria().andRoleIdEqualTo(roleId);
//        roleMenuRelationMapper.deleteByExample(example);
//        //批量插入新关系
//        for (Long menuId : menuIds) {
//            UmsRoleMenuRelation relation = new UmsRoleMenuRelation();
//            relation.setRoleId(roleId);
//            relation.setMenuId(menuId);
//            roleMenuRelationMapper.insert(relation);
//        }
//        return menuIds.size();
//    }
//
//    @Override
//    public int allocResource(Long roleId, List<Long> resourceIds) {
//        //先删除原有关系
//        UmsRoleResourceRelationExample example=new UmsRoleResourceRelationExample();
//        example.createCriteria().andRoleIdEqualTo(roleId);
//        roleResourceRelationMapper.deleteByExample(example);
//        //批量插入新关系
//        for (Long resourceId : resourceIds) {
//            UmsRoleResourceRelation relation = new UmsRoleResourceRelation();
//            relation.setRoleId(roleId);
//            relation.setResourceId(resourceId);
//            roleResourceRelationMapper.insert(relation);
//        }
//        adminCacheService.delResourceListByRole(roleId);
//        return resourceIds.size();
//    }
}
