package June.Ex25062024.Listeners;

import org.testng.IExecutionListener;
import org.testng.ISuiteListener;

public class Lab028_CustomListeners implements IExecutionListener, ISuiteListener {

    @Override
    public void onExecutionStart() {
        System.out.println("onExecutionStart");
        long startTime= System.currentTimeMillis();
        System.out.println(" ****   *** Started execution at - "+ startTime + " ****   *** ");
    }

    @Override
    public void onExecutionFinish() {
        long endTime= System.currentTimeMillis();
        System.out.println("****   *** Finished execution at - "+ endTime +" ****   *** ");
        System.out.println("onExecutionFinish");
    }
}
