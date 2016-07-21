import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class Inse6620 {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		
		if ( args.length != 2 ) {
			System.err
					.println("Usage: Inse6620 <in> <out> ");
			System.exit(2);
		}
		
		Job job = Job.getInstance( conf, "INSE 6620" ) ;
		job.setJarByClass( Inse6620.class) ;
		job.setMapperClass( Inse6620Mapper.class) ;
		//job.setCombinerClass( Inse6620Combinerclass) ;
		job.setReducerClass( Inse6620Reducer.class);
				
		job.setOutputKeyClass( Text.class );
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.addInputPath( job,  new Path(args[0]));
		FileOutputFormat.setOutputPath( job,  new Path(args[1]));
		
		System.exit(job.waitForCompletion(true) ? 0 : 1) ;

	}
}
