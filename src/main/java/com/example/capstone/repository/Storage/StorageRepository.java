package com.example.capstone.repository.Storage;


import com.example.capstone.domain.storage.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StorageRepository extends JpaRepository<Storage, Long> {
    Optional<Storage> findByStorageName(String storageName);

}
