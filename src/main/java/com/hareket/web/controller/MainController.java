package com.hareket.web.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.hareket.web.utils.MyDefaultTreeNode;
import com.hareket.web.utils.MyDefaultTreeNodeObj;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope("session")
@Controller("mainBean")
public class MainController implements Serializable {

	private static final long serialVersionUID = -1059420886077478866L;

	private TreeNode root;
	private TreeNode selectedNode;

	public static DefaultTreeNode filteredRoot;

	public MainController() {

		//***************************************************************************************************************
		root = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("HRK000", "main.lblRoot"), null);
		TreeNode administration = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("ADM000", "main.lblAdministration"), root);
			TreeNode activeConnections = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("ADM001", "main.lblActiveConnections"), administration);
			TreeNode translateTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "ADM002", "main.lblTranslateTrans"), administration);
			TreeNode authorizationTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("ATH001", "main.lblAuthorizationTrans"), administration);
		TreeNode docDatabase = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("GNL008", "main.lblDocDatabase"), root);
		TreeNode sendReceiveDocs = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("GNL009", "main.lblSendReceiveDocs"), root);
		TreeNode taskAssignments = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("GNL010", "main.lblTaskAssignments"), root);;
		TreeNode webServices = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("WBS000", "main.lblWebServices"), root);
			TreeNode mobiliz = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "WBS001", "main.lblMobiliz"), webServices);
		TreeNode rentH = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "RNT000", "main.lblRenth"), root);
			TreeNode rentSlips = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("RNT001", "main.lblRentSlips"), rentH);
			TreeNode rentTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("RNT002", "main.lblRentTrans"), rentH);
			TreeNode rentInvoiceTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("RNT003", "main.lblRentInvoiceTrans"), rentH);
			TreeNode rentDispatchPlanTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("RNT004", "main.lblRentDispatchPlanSlips"), rentH);
			TreeNode rentDispatchTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("RNT005", "main.lblRentDispatchTrans"), rentH);
		TreeNode personelMoneyDemandSlips = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "GNL001", "main.lblPersonelMoneyDemandSlips"), root);
		TreeNode accountingPaymentDemandSlips = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "GNL002", "main.lblAccountingPaymentDemandSlips"), root);
		TreeNode personelFlightTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "GNL003", "main.lblPersonelFlightTrans"), root);
		TreeNode correspondenceTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "GNL004", "main.lblCorrespondenceTrans"), root);
		TreeNode meetingTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "GNL005", "main.lblMeetingTrans"), root);
		TreeNode suggestionTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "GNL006", "main.lblSuggestionTrans"), root);
		TreeNode contractTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "GNL007", "main.lblContractTrans"), root);
		TreeNode supportDesk = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "SPD000", "main.lblSupportDesk"), root);
			TreeNode supportTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("SPD001", "main.lblSupportTrans"), supportDesk);
			TreeNode supportTaskTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("SPD001", "main.lblSupporTaskTrans"), supportDesk);
		TreeNode marketing = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "MRK000", "main.lblMarketing"), root);
			TreeNode studyTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("MRK001", "main.lblStudyTrans"), marketing);
			TreeNode workTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("MRK002", "main.lblWorkTrans"), marketing);
			TreeNode marketingDispatchSlips = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("MRK003", "main.lblMarketingDispatchSlips"), marketing);
			TreeNode referenceLetters = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("MRK004", "main.lblReferenceLetters"), marketing);
			TreeNode salesOffers = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("MSF001", "main.lblSalesOffers"), marketing);
			TreeNode crm = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("CRM000", "main.lblCrm"), marketing);
				TreeNode arpTransFrame = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("CRM001", "main.lblArpTransFrame"), crm);
				TreeNode activityTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("CRM002", "main.lblActivityTrans"), crm);
				TreeNode contactPersons = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("CRM003", "main.lblContactPersons"), crm);
				TreeNode salesOffersReport = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("MRK005", "main.lblSalesOffersReport"), crm);
		TreeNode project = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "PRJ000", "main.lblProjectManagement"), root);
			TreeNode projectSlips = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("PRJ001", "main.lblProjectSlips"), project);
			TreeNode projectDispatchSlips = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("PRJ005", "main.lblProjectDispatchSlips"), project);
			TreeNode salesOrderTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("PRJ008", "main.lblSalesOrderTrans"), project);
			TreeNode projectPlans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("PRJ006", "main.lblProjectPlans"), project);
			TreeNode supplierInfo = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("PRJ009", "main.lblSupplierInfo"), project);
			TreeNode projectNotes = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("PRJ007", "main.lblProjectNotes"), project);
			TreeNode personelDetails = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("PRJ002", "main.lblPersonelDetails"), project);
			TreeNode vehicleDetails = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("PRJ003", "main.lblVehicleDetails"), project);
			TreeNode regionReports = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ("PRJ004", "main.lblRegionReports"), project);
		TreeNode operation = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OPR000", "main.lblOperation"), root);
			TreeNode operationTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OPR001", "main.lblOperationTrans"), operation);
			TreeNode projectSlipsOperation = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OPR002", "main.lblOperationProjectSlips"), operation);
			TreeNode operationDispatch = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OPR003", "main.lblOperationDispatch"), operation);
			TreeNode operationDispatchList = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OPR004", "main.lblOperationDispatchList"), operation);
			TreeNode operationPlans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OPR005", "main.lblOperationPlans"), operation);
			TreeNode operationDispatchPackingLists = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OPR006", "main.lblOperationDispatchPackingLists"), operation);
			TreeNode operationRoadPapers = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OPR007", "main.lblOperationRoadPapers"), operation);
			TreeNode operationRoadPaperPaymentTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OPR008", "main.lblOperationRoadPaperPaymentTrans"), operation);
			TreeNode operationTrafficPenaltyTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OPR009", "main.lblOperationTrafficPenaltyTrans"), operation);
			TreeNode operationTrafficPenaltyArticles = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OPR010", "main.lblOperationTrafficPenaltyArticles"), operation);
			TreeNode operationDocumentLists = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OPR011", "main.lblOperationDocumentLists"), operation);
			TreeNode operationAssetCounterTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OPR012", "main.lblOperationAssetCounterTrans"), operation);
			TreeNode operationFerryBoatTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OPR013", "main.lblOperationFerryBoatTrans"), operation);
			TreeNode operationMaintenanceRequests = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OPR014", "main.lblOperationMeintenanceRequests"), operation);
			TreeNode operationProtocolTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OPR015", "main.lblOperationProtocolTrans"), operation);
			TreeNode projectCustoms = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "CST001", "main.lblProjectCustoms"), operation);
			TreeNode operationFuel = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OFL000", "main.lblOperationFuel"), operation);
				TreeNode operationFuelTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OFL001", "main.lblOperationFuelTrans"), operationFuel);
				TreeNode operationVehicleFuelTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OFL002", "main.lblOperationVehicleFuelTrans"), operationFuel);
			TreeNode operationTransport = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OTR000", "main.lblOperationTransport"), operation);
				TreeNode operationTruckBookTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OTR001", "main.lblOperationTruckBookTrans"), operationTransport);
				TreeNode operationTruckGears = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OTR002", "main.lblOperationTruckGears"), operationTransport);
				TreeNode operationDozvola = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OTR003", "main.lblOperationDozvola"), operationTransport);
			TreeNode operationMachinePark = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OMP000", "main.lblOperationMachinePark"), operation);
				TreeNode operationMachineParkDailyInsert = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OMP001", "main.lblOperationMachineParkDailyInsert"), operationMachinePark);
				TreeNode operationMachineParkDailyUpdate = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OMP002", "main.lblOperationMachineParkDailyUpdate"), operationMachinePark);
				TreeNode operationMachineParkDetailsUpdate = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OMP003", "main.lblOperationMachineParkDetailsUpdate"), operationMachinePark);
				TreeNode operationMachineParkGeneralReport = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OMP004", "main.lblOperationMachineParkGeneralReport"), operationMachinePark);
				TreeNode operationMachineParkAssetTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OMP005", "main.lblOperationMachineParkAssetTrans"), operationMachinePark);
				TreeNode operationMachineParkJguarUpdate = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OMP006", "main.lblOperationMachineParkJguarUpdate"), operationMachinePark);
			TreeNode operationPersonelPark = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OPP000", "main.lblOperationPersonelPark"), operation);
				TreeNode operationPersonelParkDailyInsert = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "OPP001", "main.lblOperationPersonelParkDailyInsert"), operationPersonelPark);
			TreeNode operationReports = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "ORP000", "main.lblOperationReports"), operation);
				TreeNode reportFuelCalculations = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "ORP001", "main.lblReportFuelCalculations"), operationReports);
				TreeNode reportStockMaterial = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "ORP002", "main.lblReportStockMaterial"), operationReports);
				TreeNode reportMaterialTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "ORP003", "main.lblReportMaterialTrans"), operationReports);
				TreeNode maintenanceOrder = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "ORP004", "main.lblMaintenanceOrder"), operationReports);
				TreeNode maintenanceMaterialUsage = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "ORP005", "main.lblMaintenanceMaterialUsage"), operationReports);
				TreeNode purchaseDemandTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "ORP006", "main.lblPurchaseDemandTrans"), operationReports);
				TreeNode vehicleMaterialUsage = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "ORP007", "main.lblVehicleMaterialUsage"), operationReports);
				TreeNode maintenanceWorklist = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "ORP008", "main.lblMaintenanceWorklist"), operationReports);
				TreeNode materialUsage = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "ORP009", "main.lblReportMaterialUsage"), operationReports);
				TreeNode vehicleUsage = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "ORP010", "main.lblReportVehicleUsage"), operationReports);
		TreeNode maintenance = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "MNT000", "main.lblMaintenance"), root);
			TreeNode maintenanceTrackTransNew = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "MNT001", "main.lblMaintenanceTrackTrans"), maintenance);
			TreeNode maintenanceAssetMrJobTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "MNT002", "main.lblMaintenanceAssetMrJobTrans"), maintenance);
		TreeNode stock = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "STK000", "main.lblStock"), root);
			TreeNode stockMaterialTrack = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "STK001", "main.lblStockMaterialTrack"), stock);
			TreeNode vehicleTrackTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "STK002", "main.lblVehicleTrackTrans"), stock);
			TreeNode stockSerialNoUpdate = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "STK004", "main.lblStockSerialNoUpdate"), stock);
			TreeNode stockSerialNoDispatch = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "STK005", "main.lblStockSerialNoDispatch"), stock);
			TreeNode stockMaterialPictureInsert = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "STK008", "main.lblStockMaterialPictureInsert"), stock);
			TreeNode stockOperationalPanel = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "STK009", "main.lblStockOperationalPanel"), stock);
			TreeNode wheelTrack = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "SWT000", "main.lblStockWheelTrack"), stock);
				TreeNode wheelTrackTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "SWT001", "main.lblStockWheelTrackTrans"), wheelTrack);
				TreeNode assetAxleTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "SWT002", "main.lblStockAssetAxleTrans"), wheelTrack);
		TreeNode ikNode = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "PRS000", "main.lblIKNode"), root);
			TreeNode dailyUpdateNew = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "PRS009", "main.lblDailyUpdateNew"), ikNode);
			TreeNode ikPersonelUpdate = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "PRS001", "main.lblPersonelUpdate"), ikNode);
			TreeNode countryCheck = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "PRS002", "main.lblCountryCheck"), ikNode);
			TreeNode countryReport = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "PRS003", "main.lblCountryReport"), ikNode);
			TreeNode countryCheckWhiteCollar = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "PRS004", "main.lblCountryCheckWhiteCollar"), ikNode);
			TreeNode hotelUpdate = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "PRS005", "main.lblHotelUpdate"), ikNode);
			TreeNode dispatchTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "PRS006", "main.lblDispatchTrans"), ikNode);
			TreeNode roadPaperView = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "PRS007", "main.lblRoadPaperView"), ikNode);
			TreeNode personelDocumentTrack = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "PRS008", "main.lblPersonelDocumentTrack"), ikNode);
		TreeNode quality = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "QLT000", "main.lblQuality"), root);
			TreeNode correctiveActionTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "QLT003", "main.lblCorrectiveActionTrans"), quality);
			TreeNode accidentTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "QLT001", "main.lblAccidentTrans"), quality);
			TreeNode accidentInsuranceTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "QLT002", "main.lblAccidentInsuranceTrans"), quality);
			TreeNode periodicControlTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "QLT004", "main.lblPeriodicControlTrans"), quality);
			TreeNode supplierEvaluationTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "SPT001", "main.lblSupplierEvaluationTrans"), quality);
		TreeNode education = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "EDC000", "main.lblEducation"), root);
			TreeNode educationTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "EDC001", "main.lblEducationTrans"), education);
			TreeNode personelTrackTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "EDC002", "main.lblPersonelTrackTrans"), education);
		TreeNode humanResources = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "HMR000", "main.lblHumanResources"), root);
			TreeNode personelQuitTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "HMR001", "main.lblPersonelQuitTrans"), humanResources);
			TreeNode personelPunishmentTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "HMR002", "main.lblPersonelPunishmentTrans"), humanResources);
			TreeNode personelPunishmentReports = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "HMR003", "main.lblPersonelPunishmentReports"), humanResources);
			TreeNode personelQuitTransNew = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "HMR004", "main.lblPersonelQuitTransNew"), humanResources);
			TreeNode personelTrialPeriodTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "HMR005", "main.lblPersonelTrialPeriodTrans"), humanResources);
			TreeNode personelRequest = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "HMR006", "main.lblPersonelRequest"), humanResources);
			TreeNode cvCollectionTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "HMR007", "main.lblCVCollectionTrans"), humanResources);
		TreeNode accounting = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "ACC000", "main.lblAccounting"), root);
			TreeNode materialSlipControls = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "ACC001", "main.lblMaterialSlipControls"), accounting);
			TreeNode eBookTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "ACC002", "main.lblEBookTrans"), accounting);
			TreeNode journalTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "ACC003", "main.lblJournalTrans"), accounting);
			TreeNode depreciation = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "DPR000", "main.lblDepreciation"), accounting);
				TreeNode depreciationAssets = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "DPR001", "main.lblDepreciationAssets"), depreciation);
				TreeNode depreciationTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "DPR002", "main.lblDepreciationTrans"), depreciation);
			TreeNode creditLease = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "CRL000", "main.lblCreditLease"), accounting);
				TreeNode creditLeaseTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "CRL001", "main.lblCreditLeaseTrans"), creditLease);
				TreeNode creditLeaseReport = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "CRL002", "main.lblCreditLeaseReport"), creditLease);
			TreeNode creditTrack = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "CRD000", "main.lblCreditTrack"), accounting);
				TreeNode creditTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "CRD001", "main.lblCreditTrans"), creditTrack);
		TreeNode managementReports = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "MNR000", "main.lblManagementReports"), root);
			TreeNode monthlyConsolidation = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "MNR001", "main.lblMonthlyConsolidation"), managementReports);
			TreeNode monthlyVariables = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "MNR002", "main.lblMonthlyVariables"), managementReports);
			TreeNode otherArrangements = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "MNR003", "main.lblOtherArrangements"), managementReports);
		TreeNode admWorks = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "ADW000", "main.lblAdministrationWorks"), root);
			TreeNode securityTrans = new MyDefaultTreeNode( new MyDefaultTreeNodeObj ( "ADW001", "main.lblSecurityTrans"), admWorks);

		//***************************************************************************************************************
		root.setExpanded (true);
	}

	public TreeNode getRoot() {
		return root;
	}
	
    public TreeNode getSelectedNode() {
        return selectedNode;
    }
 
    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }
	
    public void onNodeSelect(NodeSelectEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", event.getTreeNode().toString());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}