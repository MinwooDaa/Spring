package test;

public class WatchisWatch implements Watchs{
	public WatchisWatch() {
		System.out.println("애플워치 연동완료");
	}

	@Override
	public void volumeUp() {
		System.out.println("와치 볼륨 ++");
	}

	@Override
	public void volumeDown() {
		System.out.println("와치 볼륨 --");		
	}

}
