package com.example.demo.dto.user;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@NoArgsConstructor
public class UserSettingsDto {
    //@Schema(description ="설정아이디", example = "202187001C3007780EB5FPER")
    @JsonAlias("sid")
    private String sid;
    //@Schema(description ="프로젝트아이디", example = "202187001C300")
    @JsonAlias("pid")
    private String pid;
    //@Schema(description ="프로젝트명", example = "TEST-BIZ")
    @JsonAlias("project_title")
    private String project_title;
    //@Schema(description ="사용자아이디", example = "7780EB5F(수정시에만 UID값 넣음)")
    @JsonAlias("uid")
	private String uid;
    //@Schema(description ="설정유형", example = "PER")
    @JsonAlias("type")
	private String type;
    //@Schema(description ="설정코드", example = " ")
    @JsonAlias("code")
	private String code;
    //@Schema(description ="설정", example = "{\"Load Management\": {\"Help\": [{\"code\": \"HHT\", \"name\": \"Help Topic\", \"isRead\": true, \"isWrite\": true}, {\"code\": \"HA\", \"name\": \"About\", \"isRead\": true, \"isWrite\": true}], \"Report\": [{\"code\": \"RTSLL\", \"name\": \"Template Setup Load List\", \"isRead\": true, \"isWrite\": true}, {\"code\": \"RTSLS\", \"name\": \"Template Setup Load Summary\", \"isRead\": true, \"isWrite\": true}, {\"code\": \"RD\", \"name\": \"Download\", \"isRead\": true, \"isWrite\": true}, {\"code\": \"RVP\", \"name\": \"View / Print\", \"isRead\": true, \"isWrite\": true}], \"Load List\": [{\"code\": \"LLCLL\", \"name\": \"Create Load List\", \"isRead\": true, \"isWrite\": true}, {\"code\": \"LLELL\", \"name\": \"Edit Load List\", \"isRead\": true, \"isWrite\": true}, {\"code\": \"LLRC\", \"name\": \"Revision Comparison\", \"isRead\": true, \"isWrite\": true}], \"Input Data\": [{\"code\": \"IDMR\", \"name\": \"Mechanical(Retatating)\", \"isRead\": true, \"isWrite\": true}, {\"code\": \"IDMS\", \"name\": \"Mechanical(Stationary)\", \"isRead\": true, \"isWrite\": true}, {\"code\": \"IDH\", \"name\": \"HVAC\", \"isRead\": true, \"isWrite\": true}, {\"code\": \"IDI\", \"name\": \"Instrument\", \"isRead\": true, \"isWrite\": true}, {\"code\": \"IDE\", \"name\": \"Electrical\", \"isRead\": true, \"isWrite\": true}, {\"code\": \"IDA\", \"name\": \"Architecture\", \"isRead\": true, \"isWrite\": true}, {\"code\": \"IDP\", \"name\": \"Piping\", \"isRead\": true, \"isWrite\": true}, {\"code\": \"IDO\", \"name\": \"Others\", \"isRead\": true, \"isWrite\": true}, {\"code\": \"IDRC\", \"name\": \"Revision Comparison\", \"isRead\": true, \"isWrite\": true}], \"Load Summary\": [{\"code\": \"LSCLS\", \"name\": \"Create Load Summary\", \"isRead\": true, \"isWrite\": true}, {\"code\": \"LSELS\", \"name\": \"Edit Load Summary\", \"isRead\": true, \"isWrite\": true}, {\"code\": \"LSRC\", \"name\": \"Revision Comparison\", \"isRead\": true, \"isWrite\": true}], \"Project Data\": [{\"code\": \"PDHE\", \"name\": \"Handling Element\", \"isRead\": true, \"isWrite\": true}, {\"code\": \"PDS\", \"name\": \"Substation\", \"isRead\": true, \"isWrite\": true}, {\"code\": \"PDVLF\", \"name\": \"Voltage Level / Frequency\", \"isRead\": true, \"isWrite\": true}, {\"code\": \"PDOD\", \"name\": \"Operation Duty\", \"isRead\": true, \"isWrite\": true}, {\"code\": \"PDPFE\", \"name\": \"Power Factor / Efficiency\", \"isRead\": true, \"isWrite\": true}, {\"code\": \"PDLT\", \"name\": \"Load Type\", \"isRead\": true, \"isWrite\": true}]}, \"Cable Management\": {}, \"Document Generation\": {}}")
    @JsonAlias("info")
    @JsonRawValue
	private String info;

    @Builder
    public UserSettingsDto(String sid,String pid,String project_title, String uid,String type, String code, String info) {
        this.sid = sid;
        this.pid = pid;
        this.project_title=project_title;
        this.uid = uid;
        this.type = type;
        this.code = code;
        this.info = info;
    }
}
