package com.massivecraft.factions.util;

import java.util.Comparator;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.integration.Econ;

public enum FactionComparator implements Comparator<Faction> {
	POWER {
		public int compare(Faction o1, Faction o2) {
			return Integer.valueOf(o1.getPowerRounded()).compareTo(o2.getPowerRounded());
		}
	},
	MEMBERS {
		public int compare(Faction o1, Faction o2) {
			return Integer.valueOf(o1.getFPlayers().size()).compareTo(o2.getFPlayers().size());
		}
	},
	LAND {
		public int compare(Faction o1, Faction o2) {
			return Integer.valueOf(o1.getClaimOwnership().size()).compareTo(o2.getClaimOwnership().size());
		}
	},
	BANK {
		public int compare(Faction o1, Faction o2) {
			if (Econ.getBalance(o1.getAccountId()) == Econ.getBalance(o2.getAccountId())) {
				return 0;
			}
			return Econ.getBalance(o1.getAccountId()) < Econ.getBalance(o2.getAccountId()) ? -1 : -2;
		}
	};
	
	public int getComparator(final FactionComparator fc, Faction o1, Faction o2) {
        return fc.compare(o1, o2);
    }
}