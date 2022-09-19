package com.min.biz.member.impl;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.min.biz.common.JDBCUtil;
import com.min.biz.member.MemberVO;
// Component 도 가능하지만 메모리관리를 효율적으로 하기위해 Repository 를 쓴다.

public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	
	final String sql_selectOne="SELECT * FROM MEMBER WHERE MID=? ";
	final String sql_selectAll="SELECT * FROM MEMBER ";
	final String sql_insert="INSERT INTO MEMBER(MID,MPW,NAME,ROLE) VALUES(?,?,?,?)";
	final String sql_update="UPDATE MEMBER SET NAME=?,MPW=? WHERE MID=?";
	final String sql_delete="DELETE MEMBER WHERE MID=?";
	
	public void insertMember(MemberVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getRole());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	void updateMember(MemberVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_update);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getMpw());
			pstmt.setString(3, vo.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	void deleteMember(MemberVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_delete);
			pstmt.setString(1,vo.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	public MemberVO selectOneMember(MemberVO vo) {
		conn=JDBCUtil.connect();
		try {
			System.out.println("SelectOne 시작");
			pstmt=conn.prepareStatement(sql_selectOne);
			pstmt.setString(1, vo.getMid());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				MemberVO data=new MemberVO();
				data.setMid(rs.getString("MID"));
				data.setMpw(rs.getString("MPW"));
				data.setName(rs.getString("NAME"));
				data.setRole(rs.getString("ROLE"));
				System.out.println("SelectOne 끝");
				return data;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return null;
	}
	List<MemberVO> selectAllMember(MemberVO vo){
		List<MemberVO> datas=new ArrayList<MemberVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_selectAll);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberVO data=new MemberVO();
				data.setMid(rs.getString("MID"));
				data.setMpw(rs.getString("MPW"));
				data.setName(rs.getString("NAME"));
				data.setRole(rs.getString("ROLE"));
				datas.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
}
