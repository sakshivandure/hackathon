package com.example.emailservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolicyDocumentDto {
    private String documentId;
    private TransactionDto transactionDetails;
    private PolicySelectionDto policySelectionDetails;
}
