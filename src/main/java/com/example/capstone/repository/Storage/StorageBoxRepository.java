package com.example.capstone.repository.Storage;

import com.example.capstone.domain.storage.StorageBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StorageBoxRepository extends JpaRepository<StorageBox, Long> {

    public List<StorageBox> findByStorageCodeStorageCode(long storageBoxCode);




    @Query(value = "select * from STORAGEBOX WHERE STORAGE_CODE = :storage AND STORAGE_BOX_NAME= :boxName", nativeQuery = true)
    public Optional<StorageBox> findByStorageCodeAndStorageBoxName(@Param("storage")long storage, @Param("boxName")String boxName);

    @Query(value = "select m.MNICK, b.*,u.USE_STORAGE_BOX_CODE,u.USE_STORAGE_STATE from STORAGEBOX b\n" +
            "join USESTORAGEBOX u on u.STORAGE_BOX_CODE = b.STORAGE_BOX_CODE\n" +
            "join ORDERLIST o on o.ORDER_CODE = u.ORDER_CODE\n" +
            "join MEMBER m on o.MCODE = m.MCODE \n" +
            "where b.STORAGE_BOX_CODE = :storageBoxCode and sysdate >= u.USE_STORAGE_START_TIME and sysdate <= u.USE_STORAGE_END_TIME", nativeQuery = true)
    public Object[] findByBoxInformation(@Param("storageBoxCode")long storageBoxCode);

}
