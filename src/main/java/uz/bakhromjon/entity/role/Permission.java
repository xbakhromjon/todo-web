package uz.bakhromjon.entity.role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Bakhromjon Fri, 11:46 PM 2/18/2022
 */
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;

    public String getName() {
        return name;
    }

    public Permission(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
