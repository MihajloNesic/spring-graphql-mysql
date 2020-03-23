package io.gitlab.mihajlonesic.springgraphqlmysql.repository;

import io.gitlab.mihajlonesic.springgraphqlmysql.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("select p from Project p where p.user.id = :userId")
    List<Project> findUserProjects(@Param("userId") Long userId);
}