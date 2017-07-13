//package com.lxt.workflow.utils;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//
//import com.lxt.workflow.entity.jpdl.Activity;
//import com.lxt.workflow.entity.jpdl.AssignmentHandler;
//import com.lxt.workflow.entity.jpdl.Field;
//import com.lxt.workflow.entity.jpdl.Process;
//import com.lxt.workflow.entity.jpdl.End;
//import com.lxt.workflow.entity.jpdl.Task;
//import com.lxt.workflow.entity.jpdl.Transition;
//import com.lxt.workflow.entity.mxgraph.Array;
//import com.lxt.workflow.entity.mxgraph.Edge;
//import com.lxt.workflow.entity.mxgraph.Layer;
//import com.lxt.workflow.entity.mxgraph.MxCell;
//import com.lxt.workflow.entity.mxgraph.MxGeometry;
//import com.lxt.workflow.entity.mxgraph.MxGraphModel;
//import com.lxt.workflow.entity.mxgraph.MxPoint;
//import com.lxt.workflow.entity.mxgraph.Root;
//import com.lxt.workflow.entity.mxgraph.Vertex;
//import com.lxt.workflow.entity.jpdl.Start;
//import com.lxt.workflow.entity.mxgraph.Workflow;
//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.io.xml.DomDriver;
//
//public class JpdlUtils {
//	private static XStream jpdlStream = new XStream(new DomDriver());
//	private static XStream graphStream = new XStream(new DomDriver());
//
//	static{
//		graphStream.alias("mxGraphModel", com.lxt.workflow.entity.mxgraph.MxGraphModel.class);
//		
//		graphStream.alias("root", com.lxt.workflow.entity.mxgraph.Root.class);
//		graphStream.addImplicitCollection(com.lxt.workflow.entity.mxgraph.Root.class, "vertexs", com.lxt.workflow.entity.mxgraph.Vertex.class);
//		graphStream.addImplicitCollection(com.lxt.workflow.entity.mxgraph.Root.class, "edges", com.lxt.workflow.entity.mxgraph.Edge.class);
//		
//		graphStream.alias("Workflow", com.lxt.workflow.entity.mxgraph.Workflow.class);
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Workflow.class, "label");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Workflow.class, "nodeType");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Workflow.class, "workflowId");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Workflow.class, "workflowKey");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Workflow.class, "version");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Workflow.class, "status");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Workflow.class, "manual");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Workflow.class, "startRule");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Workflow.class, "beforeInEvent");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Workflow.class, "afterInEvent");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Workflow.class, "beforeOutEvent");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Workflow.class, "afterOutEvent");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Workflow.class, "launchType");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Workflow.class, "launchText");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Workflow.class, "launchValue");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Workflow.class, "memo");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Workflow.class, "href");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Workflow.class, "id");
//		
//		graphStream.alias("Layer", com.lxt.workflow.entity.mxgraph.Layer.class);
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Layer.class, "label");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Layer.class, "id");
//		
//		graphStream.alias("Start", com.lxt.workflow.entity.mxgraph.Start.class);
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Start.class, "label");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Start.class, "nodeType");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Start.class, "isSymbol");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Start.class, "id");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Start.class, "nodeId");
//		
//		graphStream.alias("End", com.lxt.workflow.entity.mxgraph.End.class);
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.End.class, "label");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.End.class, "nodeType");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.End.class, "isSymbol");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.End.class, "id");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.End.class, "nodeId");
//		
//		graphStream.alias("Task", com.lxt.workflow.entity.mxgraph.Task.class);
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Task.class, "label");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Task.class, "nodeType");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Task.class, "form");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Task.class, "formText");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Task.class, "remindRuleId");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Task.class, "remindRuleText");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Task.class, "assignerType");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Task.class, "assignerId");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Task.class, "handlerText");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Task.class, "isTakeback");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Task.class, "isDelegate");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Task.class, "isSendback");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Task.class, "sendbackWay");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Task.class, "sendbackTargetId");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Task.class, "sendbackTargetText");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Task.class, "isCheck");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Task.class, "checkTargetId");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Task.class, "checkTargetText");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Task.class, "isUpload");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Task.class, "isAdvice");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Task.class, "memo");
////		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Task.class, "href");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Task.class, "id");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Task.class, "nodeId");
//		
//		graphStream.alias("mxCell", com.lxt.workflow.entity.mxgraph.MxCell.class);
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.MxCell.class, "style");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.MxCell.class, "vertex");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.MxCell.class, "parent");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.MxCell.class, "edge");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.MxCell.class, "source");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.MxCell.class, "target");
//		
//		graphStream.alias("mxGeometry", com.lxt.workflow.entity.mxgraph.MxGeometry.class);
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.MxGeometry.class, "x");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.MxGeometry.class, "y");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.MxGeometry.class, "width");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.MxGeometry.class, "height");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.MxGeometry.class, "as");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.MxGeometry.class, "relative");
//		
//		graphStream.alias("Array", com.lxt.workflow.entity.mxgraph.Array.class);
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Array.class, "as");
//		graphStream.addImplicitCollection(com.lxt.workflow.entity.mxgraph.Array.class, "mxPoints", com.lxt.workflow.entity.mxgraph.MxPoint.class);
//		graphStream.alias("mxPoint", com.lxt.workflow.entity.mxgraph.MxPoint.class);
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.MxPoint.class, "x");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.MxPoint.class, "y");
//		
//		graphStream.alias("Edge", com.lxt.workflow.entity.mxgraph.Edge.class);
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Edge.class, "label");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Edge.class, "description");
//		graphStream.useAttributeFor(com.lxt.workflow.entity.mxgraph.Edge.class, "id");
//	}
//	
//	static {
//		jpdlStream.alias("process-definition", Process.class);
//		jpdlStream.useAttributeFor(Process.class, "name");
//		jpdlStream.useAttributeFor(Process.class, "key");
//		jpdlStream.useAttributeFor(Process.class, "xmlns");
//		jpdlStream.useAttributeFor(Process.class, "description");
//		
//		jpdlStream.addImplicitCollection(Process.class, "activities", Activity.class);
//		
//		jpdlStream.alias("task", Task.class);
//		jpdlStream.useAttributeFor(Task.class, "id");
//		jpdlStream.useAttributeFor(Task.class, "name");
//		jpdlStream.aliasField("description", Task.class, "nodeId");
//		jpdlStream.addImplicitCollection(Task.class, "transitions", Transition.class);
//		jpdlStream.alias("transition", Transition.class);
//		jpdlStream.useAttributeFor(Transition.class, "to");
//		jpdlStream.useAttributeFor(Transition.class, "name");
//		jpdlStream.aliasAttribute(Task.class, "assignmentHandler", "assignment-handler");
//		jpdlStream.aliasAttribute(AssignmentHandler.class, "clazz", "class");
//		jpdlStream.useAttributeFor(AssignmentHandler.class, "clazz");
//		jpdlStream.useAttributeFor(Field.class, "name");
//		jpdlStream.useAttributeFor(com.lxt.workflow.entity.jpdl.String.class, "value");
//		
//		jpdlStream.alias("start", Start.class);
//		jpdlStream.useAttributeFor(Start.class, "id");
//		jpdlStream.useAttributeFor(Start.class, "name");
//		jpdlStream.aliasField("description", Start.class, "nodeId");
//		jpdlStream.omitField(Start.class, "nodeId");
//		jpdlStream.addImplicitCollection(Start.class, "transitions", Transition.class);
//		
//		jpdlStream.alias("end", End.class);
//		jpdlStream.useAttributeFor(End.class, "id");
//		jpdlStream.useAttributeFor(End.class, "name");
//		jpdlStream.aliasField("description", End.class, "nodeId");
//		jpdlStream.addImplicitCollection(End.class, "transitions", Transition.class);
//		jpdlStream.omitField(End.class, "nodeId");
//	}
//	
//	public static MxGraphModel toGraphObj(String graphXml){
//		return (MxGraphModel) graphStream.fromXML(graphXml);
//	}
//	
//	public static String toGraphXml(MxGraphModel model){
//		return graphStream.toXML(model);
//	}
//	
//	public static String toJpdlXml(Process process){
//		return jpdlStream.toXML(process);
//	}
//	
//	public static Process graphToJpdl(MxGraphModel mxGraphModel){
//		Process process = new Process();
//		List<Activity> activities = process.getActivities(); 
//		
//		Root root = mxGraphModel.getRoot();
//		Workflow graphWorkflow = root.getWorkflow();
//		List<Vertex> vertexs = root.getVertexs();
//		List<Edge> edges = root.getEdges();
//		
//		process.setKey(graphWorkflow.getWorkflowKey());
//		process.setName(graphWorkflow.getLabel());
////		process.setVersion(graphWorkflow.getVersion());
//		process.setDescription(graphWorkflow.getMemo());
//		
//		Map<String, Activity> nodeMap = new HashMap<String, Activity>();
//		for(Vertex vertex : vertexs){
//			NodeBuilder nodeBuilder = NodeBuilderFactory.getBuilder(vertex);
//			Activity node = nodeBuilder.build(vertex);
//			nodeMap.put(node.getId(), node);
//		}
//		
//		for(Edge edge : edges){
//			MxCell mxCell = edge.getMxCell();
//			String source = mxCell.getSource();
//			String target = mxCell.getTarget();
//			Activity sourceActivity = nodeMap.get(source);
//			Activity targetActivity = nodeMap.get(target);
//			List<Transition> transitions = sourceActivity.getTransitions();
//			Transition transition = new Transition();
//			transition.setName(edge.getLabel());
//			transition.setTo(targetActivity.getName());
//			transitions.add(transition);
//		}
//		
//		for(Entry<String, Activity> entry : nodeMap.entrySet()){
//			Activity activity = entry.getValue();
//			activities.add(activity);
//		}
//		
//		return process;
//	}
//}
