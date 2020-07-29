package com.udacity.gradle.builditbigger;


import androidx.annotation.Nullable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.CountDownLatch;

@RunWith(JUnit4.class)
public class AsyncTaskTest {
    private String result=null;

    @Test
    public void jokeLoadedTester(){
        final CountDownLatch countDownLatch=new CountDownLatch(1);
        new EndpointsAsyncTask(new IEndpointAsyncTask() {
            @Override
            public void onRetrieveJokeFinish(@Nullable String joke) {
                result=joke;
                countDownLatch.countDown();

            }
        }).execute();
        try {
            countDownLatch.await();
            assert result!=null: "Nulll";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
