package com.warehouse.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.warehouse.bo.AdminUserDetails2;
import com.warehouse.entity.login.UmsAdmin;
import com.warehouse.entity.login.UmsAdminExample;
import com.warehouse.entity.login.UmsResource;
import com.warehouse.entity.login.UmsRole;
import com.warehouse.mapper.UmsAdminMapper;
import com.warehouse.mapper.UmsAdminRoleRelationDao;
import com.warehouse.service.UmsAdminCacheService;
import com.warehouse.service.UmsAdminService;
import com.warehouse.service.exception.Asserts;
import com.warehouse.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 后台用户管理Service实现类
 * Created by macro on 2018/4/26.
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UmsAdminMapper adminMapper;
//    @Autowired
//    private UmsAdminRoleRelationMapper adminRoleRelationMapper;
    @Autowired
    private UmsAdminRoleRelationDao adminRoleRelationDao;
//    @Autowired
//    private UmsAdminLoginLogMapper loginLogMapper;
    @Autowired
    private UmsAdminCacheService adminCacheService;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdmin admin = adminCacheService.getAdmin(username);
        if(admin!=null) return  admin;
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> adminList = adminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            admin = adminList.get(0);
            adminCacheService.setAdmin(admin);
            return admin;
        }
        return null;
    }
//
//    @Override
//    public UmsAdmin register(UmsAdminParam umsAdminParam) {
//        UmsAdmin umsAdmin = new UmsAdmin();
//        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
//        umsAdmin.setCreateTime(new Date());
//        umsAdmin.setStatus(1);
//        //查询是否有相同用户名的用户
//        UmsAdminExample example = new UmsAdminExample();
//        example.createCriteria().andUsernameEqualTo(umsAdmin.getUsername());
//        List<UmsAdmin> umsAdminList = adminMapper.selectByExample(example);
//        if (umsAdminList.size() > 0) {
//            return null;
//        }
//        //将密码进行加密操作
//        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
//        umsAdmin.setPassword(encodePassword);
//        adminMapper.insert(umsAdmin);
//        return umsAdmin;
//    }

    @Override
    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                Asserts.fail("密码不正确");
            }
            if(!userDetails.isEnabled()){
                Asserts.fail("帐号已被禁用");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
//            updateLoginTimeByUsername(username);
//            insertLoginLog(username);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }
//
//    /**
//     * 添加登录记录
//     * @param username 用户名
//     */
//    private void insertLoginLog(String username) {
//        UmsAdmin admin = getAdminByUsername(username);
//        if(admin==null) return;
//        UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
//        loginLog.setAdminId(admin.getId());
//        loginLog.setCreateTime(new Date());
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        loginLog.setIp(RequestUtil.getRequestIp(request));
//        loginLogMapper.insert(loginLog);
//    }
//
//    /**
//     * 根据用户名修改登录时间
//     */
//    private void updateLoginTimeByUsername(String username) {
//        UmsAdmin record = new UmsAdmin();
//        record.setLoginTime(new Date());
//        UmsAdminExample example = new UmsAdminExample();
//        example.createCriteria().andUsernameEqualTo(username);
//        adminMapper.updateByExampleSelective(record, example);
//    }
//
    @Override
    public String refreshToken(String oldToken) {
        return jwtTokenUtil.refreshHeadToken(oldToken);
    }
//
//    @Override
//    public UmsAdmin getItem(Long id) {
//        return adminMapper.selectByPrimaryKey(id);
//    }
//
//    @Override
//    public List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum) {
//        PageHelper.startPage(pageNum, pageSize);
//        UmsAdminExample example = new UmsAdminExample();
//        UmsAdminExample.Criteria criteria = example.createCriteria();
//        if (!StringUtils.isEmpty(keyword)) {
//            criteria.andUsernameLike("%" + keyword + "%");
//            example.or(example.createCriteria().andNickNameLike("%" + keyword + "%"));
//        }
//        return adminMapper.selectByExample(example);
//    }
//
//    @Override
//    public int update(Long id, UmsAdmin admin) {
//        admin.setId(id);
//        UmsAdmin rawAdmin = adminMapper.selectByPrimaryKey(id);
//        if(rawAdmin.getPassword().equals(admin.getPassword())){
//            //与原加密密码相同的不需要修改
//            admin.setPassword(null);
//        }else{
//            //与原加密密码不同的需要加密修改
//            if(StrUtil.isEmpty(admin.getPassword())){
//                admin.setPassword(null);
//            }else{
//                admin.setPassword(passwordEncoder.encode(admin.getPassword()));
//            }
//        }
//        int count = adminMapper.updateByPrimaryKeySelective(admin);
//        adminCacheService.delAdmin(id);
//        return count;
//    }
//
//    @Override
//    public int delete(Long id) {
//        adminCacheService.delAdmin(id);
//        int count = adminMapper.deleteByPrimaryKey(id);
//        adminCacheService.delResourceList(id);
//        return count;
//    }
//
//    @Override
//    public int updateRole(Long adminId, List<Long> roleIds) {
//        int count = roleIds == null ? 0 : roleIds.size();
//        //先删除原来的关系
//        UmsAdminRoleRelationExample adminRoleRelationExample = new UmsAdminRoleRelationExample();
//        adminRoleRelationExample.createCriteria().andAdminIdEqualTo(adminId);
//        adminRoleRelationMapper.deleteByExample(adminRoleRelationExample);
//        //建立新关系
//        if (!CollectionUtils.isEmpty(roleIds)) {
//            List<UmsAdminRoleRelation> list = new ArrayList<>();
//            for (Long roleId : roleIds) {
//                UmsAdminRoleRelation roleRelation = new UmsAdminRoleRelation();
//                roleRelation.setAdminId(adminId);
//                roleRelation.setRoleId(roleId);
//                list.add(roleRelation);
//            }
//            adminRoleRelationDao.insertList(list);
//        }
//        adminCacheService.delResourceList(adminId);
//        return count;
//    }
//
    @Override
    public List<UmsRole> getRoleList(Long adminId) {
        return adminRoleRelationDao.getRoleList(adminId);
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        List<UmsResource> resourceList = adminCacheService.getResourceList(adminId);
        if(CollUtil.isNotEmpty(resourceList)){
            return  resourceList;
        }
        resourceList = adminRoleRelationDao.getResourceList(adminId);
        if(CollUtil.isNotEmpty(resourceList)){
            adminCacheService.setResourceList(adminId,resourceList);
        }
        return resourceList;
    }
//
//    @Override
//    public int updatePassword(UpdateAdminPasswordParam param) {
//        if(StrUtil.isEmpty(param.getUsername())
//                ||StrUtil.isEmpty(param.getOldPassword())
//                ||StrUtil.isEmpty(param.getNewPassword())){
//            return -1;
//        }
//        UmsAdminExample example = new UmsAdminExample();
//        example.createCriteria().andUsernameEqualTo(param.getUsername());
//        List<UmsAdmin> adminList = adminMapper.selectByExample(example);
//        if(CollUtil.isEmpty(adminList)){
//            return -2;
//        }
//        UmsAdmin umsAdmin = adminList.get(0);
//        if(!passwordEncoder.matches(param.getOldPassword(),umsAdmin.getPassword())){
//            return -3;
//        }
//        umsAdmin.setPassword(passwordEncoder.encode(param.getNewPassword()));
//        adminMapper.updateByPrimaryKey(umsAdmin);
//        adminCacheService.delAdmin(umsAdmin.getId());
//        return 1;
//    }

    @Override
    public UserDetails loadUserByUsername(String username){
        //获取用户信息
        UmsAdmin admin = getAdminByUsername(username);
        if (admin != null) {
            List<UmsResource> resourceList = getResourceList(admin.getId());
            return new AdminUserDetails2(admin,resourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }
}
