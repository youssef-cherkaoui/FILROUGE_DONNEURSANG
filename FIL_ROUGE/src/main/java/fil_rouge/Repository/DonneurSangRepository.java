package fil_rouge.Repository;

import fil_rouge.Enums.GroupSanguin;
import fil_rouge.Model.DonneurSangModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonneurSangRepository extends JpaRepository<DonneurSangModel, Long> {

    List<DonneurSangModel> findByGroupSanguin(GroupSanguin groupSanguin);


}

