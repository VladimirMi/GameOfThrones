package ru.mikhalev.vladimir.gotfamilies.data.storage;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity(active = true, nameInDb = "CHARACTERS")
public class Character {

    @Id
    private Long id;

    @NotNull
    @Unique
    private String houseId;

    private String born;

    private String died;

    private String titles;

    private String aliases;

    private int motherId;

    private int fatherId;

    private String seasons;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 898307126)
    private transient CharacterDao myDao;

    @Generated(hash = 1795029498)
    public Character(Long id, @NotNull String houseId, String born, String died,
            String titles, String aliases, int motherId, int fatherId,
            String seasons) {
        this.id = id;
        this.houseId = houseId;
        this.born = born;
        this.died = died;
        this.titles = titles;
        this.aliases = aliases;
        this.motherId = motherId;
        this.fatherId = fatherId;
        this.seasons = seasons;
    }

    @Generated(hash = 1853959157)
    public Character() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHouseId() {
        return this.houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getBorn() {
        return this.born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getDied() {
        return this.died;
    }

    public void setDied(String died) {
        this.died = died;
    }

    public String getTitles() {
        return this.titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getAliases() {
        return this.aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

    public int getMotherId() {
        return this.motherId;
    }

    public void setMotherId(int motherId) {
        this.motherId = motherId;
    }

    public int getFatherId() {
        return this.fatherId;
    }

    public void setFatherId(int fatherId) {
        this.fatherId = fatherId;
    }

    public String getSeasons() {
        return this.seasons;
    }

    public void setSeasons(String seasons) {
        this.seasons = seasons;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 162219484)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCharacterDao() : null;
    }
}
