package uz.bakhromjon.entity.role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.entity.user.AuthUser;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Bakhromjon Fri, 11:44 PM 2/18/2022
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;

    @OneToOne
    @JoinColumn(name = "user_id")
    private AuthUser authUser;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "role_permission", joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
            , inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")})
    private Set<Permission> authorities;


    public String[] getAuthorities() {
        return authorities.stream().map(Permission::getName).toArray(String[]::new);
    }
}
