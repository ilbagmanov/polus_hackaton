package ru.polus.hackaton.build.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.polus.hackaton.build.model.Account;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> getAccountByLoginAndAndPasswordAndAndType(String login, String password, String type);
}
