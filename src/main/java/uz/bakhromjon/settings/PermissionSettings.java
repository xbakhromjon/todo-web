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
            new Permission("ADMIN_CREATE", "admin_create"),
            new Permission("ADMIN_DELETE", "admin_delete"),
            new Permission("ADMIN_UPDATE", "admin_update"),
            new Permission("ADMIN_GET", "admin_get"),
            new Permission("CREATE_USER", "create_user"),
            new Permission("USER_DELETE", "user_delete"),
            new Permission("USER_GET", "user_get"),
            new Permission("USER_UPDATE", "user_update"),
            new Permission("TASK_CREATE", "task_create"),
            new Permission("TASK_DELETE", "task_delete"),
            new Permission("TASK_UPDATE", "task_update"),
            new Permission("TASK_GET", "task_get"),
            new Permission("SUB_TASK_CREATE", "sub_task_create"),
            new Permission("SUB_TASK_DELETE", "sub_task_delete"),
            new Permission("SUB_TASK_UPDATE", "sub_task_update"),
            new Permission("SUB_TASK_GET", "sub_task_get")
    );
    public final static Role admin = new Role("ADMIN", "Admin", defaultAdminAuthorities);

    public final static Set<Permission> defaultUserAuthorities
            = Sets.newHashSet(
            new Permission("USER_DELETE", "user_delete"),
            new Permission("USER_GET", "user_get"),
            new Permission("USER_UPDATE", "user_update"),
            new Permission("TASK_CREATE", "task_create"),
            new Permission("TASK_DELETE", "task_delete"),
            new Permission("TASK_UPDATE", "task_update"),
            new Permission("TASK_GET", "task_get"),
            new Permission("SUB_TASK_CREATE", "sub_task_create"),
            new Permission("SUB_TASK_DELETE", "sub_task_delete"),
            new Permission("SUB_TASK_UPDATE", "sub_task_update"),
            new Permission("SUB_TASK_GET", "sub_task_get")
    );
    public final static Role user = new Role("USER", "user", defaultUserAuthorities);


}
