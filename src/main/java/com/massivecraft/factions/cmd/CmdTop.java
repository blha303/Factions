package com.massivecraft.factions.cmd;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;
import com.massivecraft.factions.struct.Permission;

public class CmdTop extends FCommand {

    public CmdTop() {
        super();
        this.aliases.add("top");

        this.optionalArgs.put("sort type", "power");
        this.permission = Permission.TOP.node;

        senderMustBePlayer = false;
        senderMustBeMember = false;
        senderMustBeModerator = false;
        senderMustBeAdmin = false;
    }
    
    @Override
    public void perform() {
    	String sortBy;
    	if (this.argIsSet(0)) {
    		sortBy = this.argAsString(0);
    	} else if (!fme.getSortBy().equals("unset")) {
    		sortBy = fme.getSortBy();
    	} else {
    		sortBy = "power";
    	}
    	
    	Collection<Faction> factions = Factions.i.get();
    	if (sortBy.equals("power")) {
    		Collections.sort(factions, FactionComparator.getComparator(FactionComparator.POWER));
    	}
    }

}
