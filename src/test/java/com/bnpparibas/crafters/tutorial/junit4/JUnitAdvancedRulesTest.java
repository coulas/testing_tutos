package com.bnpparibas.crafters.tutorial.junit4;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class JUnitAdvancedRulesTest extends JUnitLifeCycleTest {
    static class MyTestRule implements TestRule {
        private String context;

        public MyTestRule(String context) {
            this.context = context;
        }

        @Override
        public Statement apply(Statement base, Description description) {
            return base;
        }
    };

    @ClassRule
    public static TestRule staticRule = new MyTestRule("static");

    @Rule
    public TestRule instanceRule = new MyTestRule("instance");


}
