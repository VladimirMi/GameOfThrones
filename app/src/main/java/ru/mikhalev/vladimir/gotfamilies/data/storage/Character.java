package ru.mikhalev.vladimir.gotfamilies.data.storage;


import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Unique;

import ru.mikhalev.vladimir.gotfamilies.data.network.CharacterModelResponse;
import ru.mikhalev.vladimir.gotfamilies.utils.Helper;

@Entity(active = true, nameInDb = "CHARACTERS")
public class Character {

    @Unique
    private int id;

    private int houseId;

    @Unique
    private String name;

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

    public Character(CharacterModelResponse characterModelResponse, String houseUrl) {
        this.id = Helper.getIdFromURL(characterModelResponse.getUrl());
        this.houseId = Helper.getIdFromURL(houseUrl);
        this.name = characterModelResponse.getName();
        this.born = characterModelResponse.getBorn();
        this.died = characterModelResponse.getDied();
        this.titles = Helper.convertToDb(characterModelResponse.getTitles());
        this.aliases = Helper.convertToDb(characterModelResponse.getAliases());
        this.motherId = Helper.getIdFromURL(characterModelResponse.getMother());
        this.fatherId = Helper.getIdFromURL(characterModelResponse.getFather());
        this.seasons = Helper.convertToDb(characterModelResponse.getTvSeries());
    }

    @Generated(hash = 808332274)
    public Character(int id, int houseId, String name, String born, String died,
            String titles, String aliases, int motherId, int fatherId, String seasons) {
        this.id = id;
        this.houseId = houseId;
        this.name = name;
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

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name.isEmpty() ? "" : this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getHouseId() {
        return this.houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 162219484)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCharacterDao() : null;
    }
}
