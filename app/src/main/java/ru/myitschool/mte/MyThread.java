package ru.myitschool.mte;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MyThread extends Thread {

    private boolean flag = true;
    private Fragment fragments[];
    private FragmentManager frManager;
    private int counter = 0;

    MyThread(FragmentManager frm, Fragment[] fgmnts) {
        this.fragments = fgmnts;
        this.frManager = frm;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {

        while(flag) {
            FragmentTransaction transaction = frManager.beginTransaction();
            Fragment currentFragment = fragments[counter++ %2];
            transaction.replace(R.id.output_fragment,currentFragment);
            transaction.commit();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
