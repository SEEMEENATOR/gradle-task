package org.example;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.testing.jacoco.plugins.JacocoPlugin;
import org.gradle.testing.jacoco.tasks.JacocoReport;

public class TestReportPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        project.getPlugins().apply(JacocoPlugin.class);

        project.getTasks().create("generateTestReport", JacocoReport.class, task -> {
            task.setGroup("verification");
            task.setDescription("Generates a test coverage report.");

            task.getReports().getHtml().getRequired().set(true);
            task.getReports().getXml().getRequired().set(true);
            task.getReports().getCsv().getRequired().set(false);

            task.executionData(project.fileTree(project.getBuildDir()).include("jacoco/test.exec"));

            task.getSourceDirectories().setFrom(project.files("src/main/java"));

            task.getClassDirectories().setFrom(project.fileTree("build/classes/java/main").getFiles());

            project.getTasks().named("test", task1 -> task1.finalizedBy(task));

            task.doFirst(action -> {
                System.out.println("Execution data: " + task.getExecutionData().getFiles());
                System.out.println("Source directories: " + task.getSourceDirectories().getFiles());
                System.out.println("Class directories: " + task.getClassDirectories().getFiles());
            });
        });
    }
}
