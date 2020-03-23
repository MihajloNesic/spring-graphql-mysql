package io.gitlab.mihajlonesic.springgraphqlmysql.repository;

import io.gitlab.mihajlonesic.springgraphqlmysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}