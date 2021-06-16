package jp.jaxa.iss.kibo.rpc.defaultapk;

import jp.jaxa.iss.kibo.rpc.api.KiboRpcService;

/**
 * Class meant to handle commands from the Ground Data System and execute them in Astrobee
 */

public class YourService extends KiboRpcService {
    // write your plan 1 here
    @Override
    protected void runPlan1(){
// astrobee is undocked and the mission starts
        api.startMission();
// move to Point-A
        Point point1 = new Point(11.21, -9.8, 4.79);
        Quaternion quaternion1 = new Quaternion(0f, 0f, 0f, 1f);
        api.moveTo(point1, quaternion1, true);
        (read QR, move to Point-A’, read AR and aim the target)
        Bitmap image = api.getBitmapNavCam();
        String content = readQR(image);
        api.sendDiscoveredQR(content). // send the content of QR code for judge.
 …
 …
        // irradiate the laser
        api.laserControl(true);
        (evaluate the accuracy and retry aiming the target if necessary)
 …
 …
        // take snapshots
        // The laser accuracy is calculated from the snapshots taken by this API.
        api.takeSnapshot();
        // turn the laser off
        api.laserControl(false);
// move to the rear of Bay7
        Point point2 = new Point(10.275, -10.314, 4.295);
        Quaternion quaternion2 = new Quaternion(0f, -0.7071068f, 0f, 0.7071068f);
        api.moveTo(point2, quaternion2, true);
        // Send mission completion
        api.reportMissionCompletion();
    }

    @Override
    protected void runPlan2(){
        // write here your plan 2
    }

    @Override
    protected void runPlan3(){
        // write here your plan 3
    }

}

