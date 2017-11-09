package org.smart4j.client.security;

import org.smart4j.framework.helper.DatabaseHelper;
import org.smart4j.framework.util.CollectionUtil;
import org.smart4j.plugin.security.SmartSecurity;

import java.util.List;
import java.util.Set;

/**
 * 应用安全控制
 * Created by Administrator on 2017\11\9 0009.
 */
public class AppSecurity implements SmartSecurity {

    public String getPassword(String username) {
        String sql = "SELECT password FROM user WHERE username = ?";
        return DatabaseHelper.getEntity(String.class,sql,username);
    }

    public Set<String> getRoleNameSet(String username) {
        String sql = "SELECT r.role_name FROM user u , user_role ur , role r WHERE u.id = ur.user_id AND r.id = ur.role_id AND u.username = ?";
        List<String> list = DatabaseHelper.queryEntityList(String.class,sql,username);
        return CollectionUtil.list2Set(list);
    }

    public Set<String> getPermissionNameSet(String roleName) {
        String sql = "SELECT p.permission_name FROM role r , role_permission rp , permission p WHERE r.id = rp.role_id AND p.id = rp.permission_id AND r.role_name = ?";
        List<String> list = DatabaseHelper.queryEntityList(String.class,sql,roleName);
        return CollectionUtil.list2Set(list);
    }
}
