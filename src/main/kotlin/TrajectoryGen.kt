import com.acmerobotics.roadrunner.geometry.Pose2d
import com.acmerobotics.roadrunner.geometry.Vector2d
import com.acmerobotics.roadrunner.trajectory.Trajectory
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder
import com.acmerobotics.roadrunner.trajectory.constraints.DriveConstraints
import com.acmerobotics.roadrunner.trajectory.constraints.MecanumConstraints

object TrajectoryGen {
    // Remember to set these constraints to the same values as your DriveConstants.java file in the quickstart
    private val driveConstraints = DriveConstraints(60.0, 60.0, 0.0, 270.0.toRadians, 270.0.toRadians, 0.0)

    // Remember to set your track width to an estimate of your actual bot to get accurate trajectory profile duration!
    private const val trackWidth = 16.0

    private val combinedConstraints = MecanumConstraints(driveConstraints, trackWidth)
    private val rings = 2;
    private val startPose = Pose2d(-63.0, 15.0, 0.0)

    fun createTrajectory(): ArrayList<Trajectory> {
        val list = ArrayList<Trajectory>()
        if (rings==1) {
            val builder1 = TrajectoryBuilder(startPose, startPose.heading, combinedConstraints)

            val start2 = Pose2d(0.0, 5.0, 0.0)
            val builder2 = TrajectoryBuilder(start2, start2.heading, combinedConstraints)

            val start3 = Pose2d(0.0, 13.0, 0.0)
            val builder3 = TrajectoryBuilder(start3, start3.heading, combinedConstraints)

            val start4 = Pose2d(0.0, 21.0, 0.0)
            val builder4 = TrajectoryBuilder(start4, start4.heading, combinedConstraints)

            val start7 = Pose2d(36.0, 42.0, 0.0)
            val builder7 = TrajectoryBuilder(start7, true, combinedConstraints)

            val start8 = Pose2d(-38.0, 50.0, 270.0.toRadians)
            val builder8 = TrajectoryBuilder(start8, start8.heading, combinedConstraints)

            val start9 = Pose2d(0.0, 36.0, 0.0)
            val builder9 = TrajectoryBuilder(start9, start9.heading, combinedConstraints)
            val start10 = Pose2d(36.0, 42.0, 0.0)
            val builder10 = TrajectoryBuilder(start10, start10.heading, combinedConstraints)

            builder1
                .forward(39.0)
                .splineTo(Vector2d(0.0, 5.0), 0.0)
            builder2
                .strafeLeft(8.0)
            builder3
                .strafeLeft(8.0)
            builder4
                .splineTo(Vector2d(36.0, 42.0), 0.0.toRadians)
            builder7
                .splineTo(Vector2d(-26.0, 36.0), 180.0.toRadians)
                .splineTo(Vector2d(-38.0, 50.0), 90.0.toRadians)
            builder8
                .splineTo(Vector2d(-26.0, 36.0), 0.0.toRadians)
                .splineTo(Vector2d(0.0, 36.0), 0.0.toRadians)
            builder9
                .splineTo(Vector2d(36.0, 42.0), 0.0.toRadians)
            builder10
                .back(24.0)
            list.add(builder1.build())
            list.add(builder2.build())
            list.add(builder3.build())
            list.add(builder4.build())
            list.add(builder7.build())
            list.add(builder8.build())
            list.add(builder9.build())
            list.add(builder10.build())
        } else if (rings==2) {
            val builder1 = TrajectoryBuilder(startPose, startPose.heading, combinedConstraints)

            val start2 = Pose2d(0.0, 5.0, 0.0)
            val builder2 = TrajectoryBuilder(start2, start2.heading, combinedConstraints)

            val start3 = Pose2d(0.0, 13.0, 0.0)
            val builder3 = TrajectoryBuilder(start3, start3.heading, combinedConstraints)

            val start4 = Pose2d(0.0, 21.0, 0.0)
            val builder4 = TrajectoryBuilder(start4, start4.heading, combinedConstraints)

            val start5 = Pose2d(0.0, 36.0, 0.0)
            val builder5 = TrajectoryBuilder(start5, start5.heading, combinedConstraints)

            val start6 = Pose2d(0.0, 61.0, 0.0)
            val builder6 = TrajectoryBuilder(start6, start6.heading, combinedConstraints)

            val start7 = Pose2d(10.0, 61.0, 0.0)
            val builder7 = TrajectoryBuilder(start7, true, combinedConstraints)

            val start8 = Pose2d(-38.0, 50.0, 270.0.toRadians)
            val builder8 = TrajectoryBuilder(start8, start8.heading, combinedConstraints)

            val start9 = Pose2d(0.0, 36.0, 0.0)
            val builder9 = TrajectoryBuilder(start9, start9.heading, combinedConstraints)

            val start10 = Pose2d(0.0, 61.0, 0.0)
            val builder10 = TrajectoryBuilder(start10, start10.heading, combinedConstraints)

            builder1
                .forward(39.0)
                .splineTo(Vector2d(0.0, 5.0), 0.0)

            builder2
                .strafeLeft(8.0)
            builder3
                .strafeLeft(8.0)
            builder4
                .strafeLeft(40.0)
            builder6
                .forward(10.0)
            builder7
                .splineTo(Vector2d(-26.0, 36.0), 180.0.toRadians)
                .splineTo(Vector2d(-38.0, 50.0), 90.0.toRadians)
            builder8
                .splineTo(Vector2d(-26.0, 36.0), 0.0.toRadians)
                .splineTo(Vector2d(0.0, 36.0), 0.0.toRadians)
            builder9
                .strafeLeft(25.0)
            builder10
                .forward(10.0)

            list.add(builder1.build())
            list.add(builder2.build())
            list.add(builder3.build())
            list.add(builder4.build())
            list.add(builder6.build())
            list.add(builder7.build())
            list.add(builder8.build())
            list.add(builder9.build())
            list.add(builder10.build())
        } else {
            //Kevin code
        }

        return list
    }

    fun drawOffbounds() {
        GraphicsUtil.fillRect(Vector2d(0.0, -63.0), 18.0, 18.0) // robot against the wall
    }
}

val Double.toRadians get() = (Math.toRadians(this))
