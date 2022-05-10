package de.htwberlin.werbringts.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BringlistRepository extends JpaRepository<BringlistEntity, Long> {

    List<BringlistEntity> findAllByListName(String listName);
}
