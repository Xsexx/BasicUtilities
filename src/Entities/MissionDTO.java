package Entities;

import java.util.List;

import Base.BaseBL.Properties;

/**
 * Class that handles the mission information.
 */
public class MissionDTO
{
    public Properties MissionId;
    public String Name;
    public int RankId;
    public List<RewardDTO> RewardList;
}
