package com.hamza.Gestion_bank.mappers;

import com.hamza.Gestion_bank.dto.AccountDTO;
import com.hamza.Gestion_bank.entities.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AcountMapper {
    AcountMapper INSTANCE= Mappers.getMapper(AcountMapper.class);
    AccountDTO mapAcountToAcountDTO(Account account);
    Account mapAccountDTOToAccount(AccountDTO accountDTO);
}
