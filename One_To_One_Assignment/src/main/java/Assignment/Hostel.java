package Assignment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hostel {
	@Id
	int roomId;
	int roomNumber;
	String blockName;
	String floorNumber;
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getBlockName() {
		return blockName;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	public String getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(String floorNumber) {
		this.floorNumber = floorNumber;
	}
	@Override
	public String toString() {
		return "Hostel [roomId=" + roomId + ", roomNumber=" + roomNumber + ", blockName=" + blockName + ", floorNumber="
				+ floorNumber + "]";
	}
	

}