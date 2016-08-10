package org.catolicasc.eurocopa;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import eu.dataaccess.footballpool.InfoLocator;
import eu.dataaccess.footballpool.InfoSoapType;
import eu.dataaccess.footballpool.TFullTeamInfo;
import eu.dataaccess.footballpool.TGameInfo;
import eu.dataaccess.footballpool.TTeamCompete;
import eu.dataaccess.footballpool.TTeamInfo;
import eu.dataaccess.footballpool.TTopGoalScorer;

public class ClientSoapConnect {
	
	private InfoLocator theInfo = null;
	private InfoSoapType infoType = null;
	
	public ClientSoapConnect(){
		try {
			theInfo = new InfoLocator();
			infoType = theInfo.getInfoSoap();	 		
		} catch(ServiceException se){
			System.out.println(se);
		}
	}

	public TGameInfo[] getGames(){
		TGameInfo games[] = null;
		try{
			games = infoType.allGames();	
		} catch(RemoteException re){
			
		}	
		return games;		
	}
	
	public TTeamInfo[] getTeams(){
		TTeamInfo teams[] = null;
		try{
			teams = infoType.teams();	
		} catch(RemoteException re){
			
		}	
		return teams;		
	}
	
	public TFullTeamInfo getTeamsInfo(String name){
		TFullTeamInfo teams = null;
		try{
			teams = infoType.fullTeamInfo(name);	
		} catch(RemoteException re){
			
		}	
		return teams;		
	}
	
	public TTopGoalScorer[] getTopGolScorrer(){
		TTopGoalScorer[] scorrer = null;
		try{
			scorrer = infoType.topGoalScorers(10000);	
		} catch(RemoteException re){
			
		}	
		return scorrer;		
	}

}
