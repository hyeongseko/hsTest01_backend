package com.shTest.equipment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AtchFileDto {
    // 파일 정보들
    private int atchFileId;
    private int atchDetailFileId;
    private String atchFilePath;
    private String atchFileExtn;
    private String atchFileOrginNm;
    private long atchFileSize;
}
