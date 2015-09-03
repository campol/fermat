package com.bitdubai.fermat_dmp_plugin.layer.actor.extra_user.developer.bitdubai.version_1.structure;

import com.bitdubai.fermat_api.layer.all_definition.enums.Actors;
import com.bitdubai.fermat_api.layer.dmp_actor.Actor;

import java.math.BigInteger;
import java.util.UUID;

/**
 * Created by ciencias on 3/18/15.
 *
 */
public class ExtraUser implements Actor {

    /**
     * ExtraUser Interface member variables.
     */
    private byte[] photo;
    private String name;
    private String actorPublicKey;

    /**
     * User interface implementation.
     */


    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setActorPublicKey(String actorPublicKey) {
        this.actorPublicKey = actorPublicKey;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getActorPublicKey() {
        return this.actorPublicKey;
    }

    @Override
    public Actors getType(){
        return Actors.EXTRA_USER;
    }

    @Override
    public byte[] getPhoto() {
        return this.photo;
    }

    @Override
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }


}
