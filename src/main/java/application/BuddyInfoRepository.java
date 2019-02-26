package application;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "buddy", path = "buddy.json")
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, String> {
    List<BuddyInfo> findAll();
    List<BuddyInfo> findByName(@Param("name") String name);
}