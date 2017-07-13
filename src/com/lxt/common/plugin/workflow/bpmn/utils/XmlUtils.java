package com.lxt.common.plugin.workflow.bpmn.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.lxt.common.plugin.workflow.bpmn.entity.AbstractActivity;
import com.lxt.common.plugin.workflow.bpmn.entity.AbstractTransition;
import com.lxt.common.plugin.workflow.bpmn.entity.Definitions;
import com.lxt.common.plugin.workflow.bpmn.entity.EndEvent;
import com.lxt.common.plugin.workflow.bpmn.entity.Process;
import com.lxt.common.plugin.workflow.bpmn.entity.SequenceFlow;
import com.lxt.common.plugin.workflow.bpmn.entity.StartEvent;
import com.lxt.common.plugin.workflow.bpmn.entity.UserTask;
import com.lxt.common.plugin.workflow.bpmn.entity3.Activity;
import com.lxt.common.plugin.workflow.bpmn.entity3.Transition;
import com.lxt.common.plugin.workflow.graph.entity.Array;
import com.lxt.common.plugin.workflow.graph.entity.Edge;
import com.lxt.common.plugin.workflow.graph.entity.End;
import com.lxt.common.plugin.workflow.graph.entity.Layer;
import com.lxt.common.plugin.workflow.graph.entity.MxCell;
import com.lxt.common.plugin.workflow.graph.entity.MxGeometry;
import com.lxt.common.plugin.workflow.graph.entity.MxGraphModel;
import com.lxt.common.plugin.workflow.graph.entity.MxPoint;
import com.lxt.common.plugin.workflow.graph.entity.Root;
import com.lxt.common.plugin.workflow.graph.entity.Start;
import com.lxt.common.plugin.workflow.graph.entity.Task;
import com.lxt.common.plugin.workflow.graph.entity.Vertex;
import com.lxt.common.plugin.workflow.graph.entity.Workflow;
import com.lxt.common.plugin.workflow.graph.utils.NodeBuilder;
import com.lxt.common.plugin.workflow.graph.utils.NodeBuilderFactory;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XmlUtils {
	private static XStream bpmnStream = new XStream(new DomDriver());
	private static XStream graphStream = new XStream(new DomDriver());

	/**
	 * 装载graph解释器
	 */
	static{
		graphStream.alias("mxGraphModel", MxGraphModel.class);
		
		graphStream.alias("root", Root.class);
		graphStream.addImplicitCollection(Root.class, "vertexs", Vertex.class);
		graphStream.addImplicitCollection(Root.class, "edges", Edge.class);
		
		graphStream.alias("Workflow", Workflow.class);
		graphStream.useAttributeFor(Workflow.class, "label");
		graphStream.useAttributeFor(Workflow.class, "nodeType");
		graphStream.useAttributeFor(Workflow.class, "workflowId");
		graphStream.useAttributeFor(Workflow.class, "workflowKey");
		graphStream.useAttributeFor(Workflow.class, "version");
		graphStream.useAttributeFor(Workflow.class, "status");
		graphStream.useAttributeFor(Workflow.class, "memo");
		graphStream.useAttributeFor(Workflow.class, "id");
		
		graphStream.alias("Layer", Layer.class);
		graphStream.useAttributeFor(Layer.class, "label");
		graphStream.useAttributeFor(Layer.class, "id");
		
		graphStream.alias("Start", Start.class);
		graphStream.useAttributeFor(Start.class, "label");
		graphStream.useAttributeFor(Start.class, "nodeType");
		graphStream.useAttributeFor(Start.class, "isSymbol");
		graphStream.useAttributeFor(Start.class, "id");
		graphStream.useAttributeFor(Start.class, "nodeId");
		
		graphStream.alias("End", End.class);
		graphStream.useAttributeFor(End.class, "label");
		graphStream.useAttributeFor(End.class, "nodeType");
		graphStream.useAttributeFor(End.class, "isSymbol");
		graphStream.useAttributeFor(End.class, "id");
		graphStream.useAttributeFor(End.class, "nodeId");
		
		graphStream.alias("Task", Task.class);
		graphStream.useAttributeFor(Task.class, "label");
		graphStream.useAttributeFor(Task.class, "nodeType");
		graphStream.useAttributeFor(Task.class, "form");
//		graphStream.useAttributeFor(Task.class, "formText");
//		graphStream.useAttributeFor(Task.class, "remindRuleId");
//		graphStream.useAttributeFor(Task.class, "remindRuleText");
		graphStream.useAttributeFor(Task.class, "assignerType");
		graphStream.useAttributeFor(Task.class, "assignerId");
//		graphStream.useAttributeFor(Task.class, "handlerText");
//		graphStream.useAttributeFor(Task.class, "isTakeback");
//		graphStream.useAttributeFor(Task.class, "isDelegate");
//		graphStream.useAttributeFor(Task.class, "isSendback");
//		graphStream.useAttributeFor(Task.class, "sendbackWay");
//		graphStream.useAttributeFor(Task.class, "sendbackTargetId");
//		graphStream.useAttributeFor(Task.class, "sendbackTargetText");
//		graphStream.useAttributeFor(Task.class, "isCheck");
//		graphStream.useAttributeFor(Task.class, "checkTargetId");
//		graphStream.useAttributeFor(Task.class, "checkTargetText");
//		graphStream.useAttributeFor(Task.class, "isUpload");
//		graphStream.useAttributeFor(Task.class, "isAdvice");
//		graphStream.useAttributeFor(Task.class, "memo");
//		graphStream.useAttributeFor(Task.class, "href");
		graphStream.useAttributeFor(Task.class, "id");
		graphStream.useAttributeFor(Task.class, "nodeId");
		
		graphStream.alias("mxCell", MxCell.class);
		graphStream.useAttributeFor(MxCell.class, "style");
		graphStream.useAttributeFor(MxCell.class, "vertex");
		graphStream.useAttributeFor(MxCell.class, "parent");
		graphStream.useAttributeFor(MxCell.class, "edge");
		graphStream.useAttributeFor(MxCell.class, "source");
		graphStream.useAttributeFor(MxCell.class, "target");
		
		graphStream.alias("mxGeometry", MxGeometry.class);
		graphStream.useAttributeFor(MxGeometry.class, "x");
		graphStream.useAttributeFor(MxGeometry.class, "y");
		graphStream.useAttributeFor(MxGeometry.class, "width");
		graphStream.useAttributeFor(MxGeometry.class, "height");
		graphStream.useAttributeFor(MxGeometry.class, "as");
		graphStream.useAttributeFor(MxGeometry.class, "relative");
		
		graphStream.alias("Array", Array.class);
		graphStream.useAttributeFor(Array.class, "as");
		graphStream.addImplicitCollection(Array.class, "mxPoints", MxPoint.class);
		graphStream.alias("mxPoint", MxPoint.class);
		graphStream.useAttributeFor(MxPoint.class, "x");
		graphStream.useAttributeFor(MxPoint.class, "y");
		
		graphStream.alias("Edge", Edge.class);
		graphStream.useAttributeFor(Edge.class, "label");
		graphStream.useAttributeFor(Edge.class, "description");
		graphStream.useAttributeFor(Edge.class, "id");
	}
	
	/**
	 * 装载bpmn解释器
	 */
	static {
		bpmnStream.alias("definitions", Definitions.class);
		bpmnStream.useAttributeFor(Definitions.class, "id");
		bpmnStream.useAttributeFor(Definitions.class, "targetNamespace");
		bpmnStream.aliasAttribute(Definitions.class, "xmlnsActiviti", "xmlns:activiti");
		bpmnStream.useAttributeFor(Definitions.class, "xmlns");
		
		bpmnStream.alias("process", Process.class);
		bpmnStream.useAttributeFor(Process.class, "id");
		bpmnStream.useAttributeFor(Process.class, "name");
		
		bpmnStream.addImplicitCollection(Process.class, "activities", AbstractActivity.class);
		bpmnStream.addImplicitCollection(Process.class, "transitions", AbstractTransition.class);
		
		bpmnStream.alias("startEvent", StartEvent.class);
		bpmnStream.useAttributeFor(StartEvent.class, "id");
		bpmnStream.useAttributeFor(StartEvent.class, "name");
		
		bpmnStream.alias("endEvent", EndEvent.class);
		bpmnStream.useAttributeFor(EndEvent.class, "id");
		bpmnStream.useAttributeFor(EndEvent.class, "name");
		
		bpmnStream.alias("userTask", UserTask.class);
		bpmnStream.alias("sequenceFlow", SequenceFlow.class);
		bpmnStream.useAttributeFor(SequenceFlow.class, "id");
		bpmnStream.useAttributeFor(SequenceFlow.class, "sourceRef");
		bpmnStream.useAttributeFor(SequenceFlow.class, "targetRef");
	}
	
	public static MxGraphModel toGraphObj(String graphXml){
		return (MxGraphModel) graphStream.fromXML(graphXml);
	}
	
	public static String toGraphXml(MxGraphModel model){
		return graphStream.toXML(model);
	}
	
	public static String toBpmnXml(Definitions definitions){
		return bpmnStream.toXML(definitions);
	}
	
	public static Process parseBpmn(MxGraphModel mxGraphModel){
		Process process = new Process();
		List<AbstractActivity> activities = process.getActivities(); 
		
		Root root = mxGraphModel.getRoot();
		Workflow graphWorkflow = root.getWorkflow();
		List<Vertex> vertexs = root.getVertexs();
		List<Edge> edges = root.getEdges();
		
		process.setId(graphWorkflow.getWorkflowKey());
		process.setName(graphWorkflow.getLabel());
//		process.setVersion(graphWorkflow.getVersion());
		
		Map<String, Activity> nodeMap = new HashMap<String, Activity>();
		for(Vertex vertex : vertexs){
			NodeBuilder nodeBuilder = NodeBuilderFactory.getBuilder(vertex);
			Activity node = nodeBuilder.build(vertex);
			nodeMap.put(node.getId(), node);
		}
		
		for(Edge edge : edges){
			MxCell mxCell = edge.getMxCell();
			String source = mxCell.getSource();
			String target = mxCell.getTarget();
			Activity sourceActivity = nodeMap.get(source);
			Activity targetActivity = nodeMap.get(target);
			List<Transition> transitions = sourceActivity.getTransitions();
			Transition transition = new Transition();
			transition.setName(edge.getLabel());
			transition.setTo(targetActivity.getName());
			transitions.add(transition);
		}
		
		for(Entry<String, Activity> entry : nodeMap.entrySet()){
			Activity activity = entry.getValue();
			//activities.add(activity);
		}
		
		return process;
	}
}
