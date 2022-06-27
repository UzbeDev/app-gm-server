package uz.itca.gm_aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.itca.gm_aplication.entity.Role;
import uz.itca.gm_aplication.entity.enums.RoleName;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleName(RoleName roleName);
}
