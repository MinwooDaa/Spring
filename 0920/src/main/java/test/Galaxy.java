package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("gp")

public class Galaxy implements Phone {
	@Autowired
	private Watchs watch;
	private int battery;

	public Galaxy() {
		System.out.println("갤럭시 생성완료");
		// 기본생성자 필수
	}
	public Galaxy(Watchs watch) {
		System.out.println("갤럭시 객체생성완료");
		this.watch=watch;
	}
	public Galaxy(int battery ,Watchs watch) {
		System.out.println("갤럭시 객체생성완료");
		this.watch=watch;
		this.battery=battery;
	}
	public Watchs getWatch() {
		return watch;
	}
	public void setWatch(Watchs watch) {
		System.out.println("Setter 호출됨 - 3 ");
		this.watch = watch;
	}
	public int getBattery() {
		return battery;
	}
	public void setBattery(int battery) {
		System.out.println("Setter 호출됨 - 4 ");
		this.battery = battery;
	}
	@Override
	public void powerOn() {
		System.out.println("갤럭시 전원 ON  배터리 잔량" + this.battery+"%");
	}
	@Override
	public void powerOff() {
		System.out.println("갤럭시 전원 OFF");
	}
	@Override
	public void volumeUp() {
		System.out.println("갤럭시 소리 ++");
		this.watch.volumeUp();
	}
	@Override
	public void volumeDown() {
		System.out.println("갤럭시 소리 --");
		this.watch.volumeDown();
	}
	
}
