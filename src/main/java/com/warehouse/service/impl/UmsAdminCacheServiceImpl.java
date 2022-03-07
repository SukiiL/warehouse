package com.warehouse.service.impl;


import com.warehouse.entity.login.UmsResource;
import com.warehouse.entity.login.UmsAdmin;
import com.warehouse.mapper.UmsAdminRoleRelationDao;
import com.warehouse.service.RedisService;
import com.warehouse.service.UmsAdminCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 后台用户缓存操作Service实现类
 * Created by macro on 2020/3/13.
 */
@Service
public class UmsAdminCacheServiceImpl implements UmsAdminCacheService {
//    @Autowired
//    private UmsAdminService adminService;
    @Resource
    private RedisService redisService;
//    @Autowired
//    private UmsAdminRoleRelationMapper adminRoleRelationMapper;
    @Autowired
    private UmsAdminRoleRelationDao adminRoleRelationDao;
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;
    @Value("${redis.key.resourceList}")
    private String REDIS_KEY_RESOURCE_LIST;

//    @Override
//    public void delAdmin(Long adminId) {
//        UmsAdmin admin = adminService.getItem(adminId);
//        if (admin != null) {
//            String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getUsername();
//            redisService.del(key);
//        }
//    }
//
//    @Override
//    public void delResourceList(Long adminId) {
//        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
//        redisService.del(key);
//    }
//
//    @Override
//    public void delResourceListByRole(Long roleId) {
//        UmsAdminRoleRelationExample example = new UmsAdminRoleRelationExample();
//        example.createCriteria().andRoleIdEqualTo(roleId);
//        List<UmsAdminRoleRelation> relationList = adminRoleRelationMapper.selectByExample(example);
//        if (CollUtil.isNotEmpty(relationList)) {
//            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
//            List<String> keys = relationList.stream().map(relation -> keyPrefix + relation.getAdminId()).collect(Collectors.toList());
//            redisService.del(keys);
//        }
//    }
//
//    @Override
//    public void delResourceListByRoleIds(List<Long> roleIds) {
//        UmsAdminRoleRelationExample example = new UmsAdminRoleRelationExample();
//        example.createCriteria().andRoleIdIn(roleIds);
//        List<UmsAdminRoleRelation> relationList = adminRoleRelationMapper.selectByExample(example);
//        if (CollUtil.isNotEmpty(relationList)) {
//            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
//            List<String> keys = relationList.stream().map(relation -> keyPrefix + relation.getAdminId()).collect(Collectors.toList());
//            redisService.del(keys);
//        }
//    }
//
//    @Override
//    public void delResourceListByResource(Long resourceId) {
//        List<Long> adminIdList = adminRoleRelationDao.getAdminIdList(resourceId);
//        if (CollUtil.isNotEmpty(adminIdList)) {
//            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
//            List<String> keys = adminIdList.stream().map(adminId -> keyPrefix + adminId).collect(Collectors.toList());
//            redisService.del(keys);
//        }
//    }

    @Override
    public UmsAdmin getAdmin(String username) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + username;
        return (UmsAdmin) redisService.get(key);
    }

    @Override
    public void setAdmin(UmsAdmin admin) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getUsername();
        redisService.set(key, admin, REDIS_EXPIRE);
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        return (List<UmsResource>) redisService.get(key);
    }

    @Override
    public void setResourceList(Long adminId, List<UmsResource> resourceList) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        redisService.set(key, resourceList, REDIS_EXPIRE);
    }
}
