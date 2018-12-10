package com.dxc.minifilesharing.user.entity;


import com.dxc.minifilesharing.user.common.AccountLevelType;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ACCOUNT_LEVEL")
public class AccountLevelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "ACCOUNT_LEVEL_TYPE", nullable = false)
    private AccountLevelType accountLevelType;

    @Size(min = 1, max = 36)
    @Column(name = "ACCOUNT_LEVEL_ID", nullable = false, unique = true, length = 36)
    private String accountLevelId;

    @Column(name = "MAX_DOWNLOAD_SIZE", nullable = false)
    private int maxDownloadSize;

    @Column(name = "MAX_UPLOAD_SIZE", nullable = false)
    private int maxUploadSize;

    @Column(name = "REQUIRED_UPLOAD_SIZE", nullable = false)
    private int requiredUploadSize;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accountLevel")
    private List<UserEntity> userEntityList;

    @Column(name = "CREATE_DATE", nullable = false)
    private Date createDate;

    @Column(name = "MODIFIED_DATE", nullable = false)
    private Date modifiedDate;

    @PrePersist
    public void prePersist() {
        createDate = new Date();
        modifiedDate = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        modifiedDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountLevelId() {
        return accountLevelId;
    }

    public void setAccountLevelId(String accountLevelId) {
        this.accountLevelId = accountLevelId;
    }

    public int getMaxDownloadSize() {
        return maxDownloadSize;
    }

    public void setMaxDownloadSize(int maxDownloadSize) {
        this.maxDownloadSize = maxDownloadSize;
    }

    public int getMaxUploadSize() {
        return maxUploadSize;
    }

    public void setMaxUploadSize(int maxUploadSize) {
        this.maxUploadSize = maxUploadSize;
    }

    public int getRequiredUploadSize() {
        return requiredUploadSize;
    }

    public void setRequiredUploadSize(int requiredUploadSize) {
        this.requiredUploadSize = requiredUploadSize;
    }

    public List<UserEntity> getUserEntityList() {
        return userEntityList;
    }

    public void setUserEntityList(List<UserEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }

    public AccountLevelType getAccountLevelType() {
        return accountLevelType;
    }

    public void setAccountLevelType(AccountLevelType accountLevelType) {
        this.accountLevelType = accountLevelType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "AccountLevelEntity{" +
                "id=" + id +
                ", accountLevelType=" + accountLevelType +
                ", accountLevelId='" + accountLevelId + '\'' +
                ", maxDownloadSize=" + maxDownloadSize +
                ", maxUploadSize=" + maxUploadSize +
                ", requiredUploadSize=" + requiredUploadSize +
                ", userEntityList=" + userEntityList +
                ", createDate=" + createDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
