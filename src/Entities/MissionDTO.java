package Entities;

import java.util.List;

import Base.Base.Mission;

/**
 * Class that handles the mission information.
 */
public class MissionDTO
{
    public Mission MissionId;
    public String Name;
    public int RankId;
    public List<RewardDTO> RewardList;
}
