package com.chandan.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.concox.model.DataPacket;
import com.gps.packetfactory.DataPacketFactory;

public class DataPacketTest {

	@Test
	public void testLoginPacket() {
		//fail("Not yet implemented");
	}

	@Test
	public void testLocationPacket() {
		DataPacket dataPacket = DataPacketFactory.getDataPacket("78 78 1F 12 0B 08 1D 11 2E 10 CC 02 7A C7 EB 0C 46 58 49 00 14 8F 01 CC 00 28 7D 00 1F B8 00 03 80 81 0D 0A", "CONCOX");
		assertNotNull(dataPacket);
		System.out.println(dataPacket);
	}
}
