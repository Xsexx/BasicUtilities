package Entities;

import java.util.List;

import Base.Base.Mission;

/**
 * Class that handles the mission information.
 */
public class MissionDTO
{
    public RankDTO Rank;
    public Mission Id;
    public String Name;
    public ObjectiveDTO Objective;
    public List<RewardDTO> RewardList;
}
