package com.brianedwards.springbootsecurity.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "aplctn_user")
public class User {

    @Id
    private Integer aplctnUserId;
    @Column(name = "user_1st_name")
    private String user1stName;
    private String eidmUserId;
    private String euaUserId;
    private String actvInd;
    private String userLastName;
    private String userEmailId;
    private Integer updtUserId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date insrtUserTs;
    private Integer insrtUserId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updtUserTs;
    private Integer aplctnUserTypeId;
    private String userStateCd;
    private Integer aplctnUserInactvRsnId;
    private String aplctnUserDltSw;
    private String userPhneExtnsnNum;
    private String userPhneNum;
    private String userFaxNum;
    private String userCorpName;
    private String mdpActvInd;
    private String roleActvInd;
    private Integer aplctnUserAudtTrkId;

}
