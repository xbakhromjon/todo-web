package uz.bakhromjon.settings;

import com.google.common.collect.Sets;
import uz.bakhromjon.entity.role.Permission;
import uz.bakhromjon.entity.role.Role;

import java.util.Set;

/**
 * @author Bakhromjon Sat, 4:08 PM 2/19/2022
 */
public class PermissionSettings {
    public final static Set<Permission> defaultAdminAuthorities
            = Sets.newHashSet(
            new Permission("CREATE_ADMIN", "create_admin"),
            new Permission("delete_ADMIN", "delete_admin"),
            new Permission("update_ADMIN", "update_admin"),
            new Permission("get_ADMIN", "get_admin"),
            new Permission("CREATE_user", "create_user"),
            new Permission("delete_user", "delete_user"),
            new Permission("get_user", "get_user"),
            new Permission("update_user", "update_user"),
            new Permission("create_task", "create_task"),
            new Permission("delete_task", "delete_task"),
            new Permission("update_task", "update_task"),
            new Permission("get_task", "get_task"),
            new Permission("create_sub_task", "create_sub_task"),
            new Permission("delete_sub_task", "delete_sub_task"),
            new Permission("update_sub_task", "update_sub_task"),
            new Permission("get_sub_task", "get_sub_task")
    );
    public final static Role admin = new Role("ADMIN", "Admin", defaultAdminAuthorities);

    public final static Set<Permission> defaultUserAuthorities
            = Sets.newHashSet(
            new Permission("delete_user", "delete_user"),
            new Permission("get_user", "get_user"),
            new Permission("update_user", "update_user"),
            new Permission("create_task", "create_task"),
            new Permission("delete_task", "delete_task"),
            new Permission("update_task", "update_task"),
            new Permission("get_task", "get_task"),
            new Permission("create_sub_task", "create_sub_task"),
            new Permission("delete_sub_task", "delete_sub_task"),
            new Permission("update_sub_task", "update_sub_task"),
            new Permission("get_sub_task", "get_sub_task")
    );
    public final static Role user = new Role("USER", "user", defaultUserAuthorities);


}
