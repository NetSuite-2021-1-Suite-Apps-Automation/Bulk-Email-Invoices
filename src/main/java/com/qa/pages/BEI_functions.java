package com.qa.pages;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.checkerframework.checker.units.qual.s;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.util.TestBase;
import com.qa.util.TestUtil;

public class BEI_functions extends TestBase {

	// customer in bei

	@FindBy(xpath = "//a[@id='custpage_client_popup_muli']//following-sibling::a[@class='fwpopupsel']")
	WebElement customer_arrow;

	@FindBy(xpath = "//a[@id='custpage_client_popup_list']")
	WebElement pop_up_list;

	@FindBy(xpath = "//input[@id='st']")
	WebElement input_customer;

	@FindBy(xpath = "//input[@id='Search']")
	WebElement search_customer;

	@FindBy(xpath = "//div[@id='inner_popup_div']//table//tbody//tr")
	List<WebElement> customer_list;

	@FindBy(xpath = "//input[@name='custpage_includesubtrans_send']//following-sibling::img")
	WebElement show_parent_emails;

	@FindBy(xpath = "//h2[@title='Total Amount Followed Up']")
	WebElement hover_on_follow;

	@FindBy(xpath = "//span[@id='ns-component-5058551695101061--1127946376']")
	WebElement over_total_refresh;

	@FindBy(xpath = "//table[@id='neg60__tab']//tbody//tr[@id='totalRow']//a")
	WebElement over_total;

	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//td[count(//td[@data-label='Internal ID']//preceding-sibling::td)]//a[@class='dottedlink viewitem']")
	List<WebElement> partially_paid_invoices;

	@FindBy(xpath = "//span[@id='custbody_tss_bei_dunning_fs_lbl_uir_label']//following-sibling::span")
	WebElement dunning_field_value;

	@FindBy(xpath = "//span[@id='custbody_tss_bei_sent_date_fs_lbl_uir_label']//following-sibling::span")
	WebElement auto_email_send_date_in_bei;

	@FindBy(xpath = "//input[@name='inpt_Transaction_NAME']")
	WebElement name_arrow;

	@FindBy(xpath = "//td[contains(@id,'row_Transaction_NAME1_')]//a")
	List<WebElement> name_filter_list;

	@FindBy(xpath = "//input[@id='custpage_fromdate']")
	WebElement form_date;

	@FindBy(xpath = "//input[@id='custpage_todate']")
	WebElement to_date;

	@FindBy(xpath = "//td[@id='tdbody_custpage_filter']")
	WebElement search_button;

	@FindBy(xpath = "//a[@id='custpage_client_popup_muli']//following-sibling::a")
	WebElement customer_move_arrow_in_invoice;
	
	@FindBy(xpath = "//a[@id='custpage_client_popup_link']")
	WebElement customer_open_arrow;
	
	@FindBy(xpath = "//td[@id='custom379lnk']")
	WebElement bulk_email_tab_in_customer;
	
	@FindBy(xpath = "//span[@id='custentity_tss_bei_exculed_from_bei_fs']")
	WebElement exclude_checkbox_in_customer;
	
	
	@FindBy(xpath = "//span[@id='custpage_selected_recs_fs_lbl_uir_label']//following-sibling::span")
	WebElement no_of_selected_invoices_checkbox;

	@FindBy(xpath = "//td[@id='tdbody_custpage_submit']")
	WebElement process_button;

	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[@id='custpage_listheader']//following-sibling::tr//td[count(//td[@data-label='NAME']//preceding-sibling::td)+1]")
	List<WebElement> invoices_date_range_dates;

	@FindBy(xpath = "//input[@id='custpage_client_display']")
	WebElement customer_name;

	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[@id='custpage_listheader']//following-sibling::tr//td[count(//td[@data-label='DOCUMENT NUMBER']//preceding-sibling::td)+2]")
	List<WebElement> invoices_with_customer_name;

	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[@id='custpage_listheader']//following-sibling::tr//td[count(//td[@data-label='MEMO']//preceding-sibling::td)+3]//a")
	List<WebElement> doc_nr;

	@FindBy(xpath = "//input[@name='inpt_custpage_department']")
	WebElement department;

	@FindBy(xpath = "//input[@name='inpt_custpage_class']")
	WebElement classs;

	@FindBy(xpath = "//input[@name='inpt_custpage_location']")
	WebElement location;

	@FindBy(xpath = "//span[@id='department_fs_lbl_uir_label']//following-sibling::span")
	WebElement dept_in_invoice;

	@FindBy(xpath = "//span[@id='class_fs_lbl_uir_label']//following-sibling::span")
	WebElement class_in_invoice;

	@FindBy(xpath = "//span[@id='location_fs_lbl_uir_label']//following-sibling::span")
	WebElement loc_in_invoice;

	@FindBy(xpath = "//input[@id='custpage_duedate']")
	WebElement due_datee;

	@FindBy(xpath = "//span[@id='duedate_fs_lbl_uir_label']//following-sibling::span")
	WebElement due_date_after_save;

	@FindBy(xpath = "//span[@id='duedate_fs_lbl_uir_label']//following-sibling::span")
	WebElement due_date_in_invoice;

	@FindBy(xpath = "//input[@name='custpage_paidinfull_send']//following-sibling::img")
	WebElement show_only_open_invoices;

	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[@id='custpage_listheader']//following-sibling::tr//td[count(//td[@data-label='TYPE']//preceding-sibling::td)+3]")
	List<WebElement> open_status;

	@FindBy(xpath = "//span[@id='custpage_showcreditmemos_fs']")
	WebElement credit_memos;

	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[@id='custpage_listheader']//following-sibling::tr//td[count(//td[@data-label='Subsidiary']//preceding-sibling::td)+3]")
	List<WebElement> tran_type;

	@FindBy(xpath = "//input[@name='custpage_resendemail_send']//following-sibling::img")
	WebElement show_emailed_invoices;

	@FindBy(xpath = "//td[@id='custom44lnk']")
	WebElement bulk_email_invoices_tab;

	@FindBy(xpath = "//table[@id='recmachcustrecord_tss_attach_to_tran__tab']//tbody//tr//td[count(//td[@data-label='BULK EMAIL SEND DATE']//preceding-sibling::td)]")
	WebElement email_status_in_invoice;

	@FindBy(xpath = "//td[@id='tdbody_custpage_unmarkall_btn']")
	WebElement unmark_all;

	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[@id='custpage_listheader']//following-sibling::tr//td[count(//td[@data-label='DATE']//preceding-sibling::td)]//img")
	List<WebElement> select_invoices;

	@FindBy(xpath = "//input[@name='custpage_exclude_send']//following-sibling::img")
	WebElement exclue_selected_invoices_checkbox;

	@FindBy(xpath = "//a[@class='ns-scroll-button ns-scroll-button-bottom']")
	WebElement arrow;

	@FindBy(xpath = "//input[@name='custpage_excludeemail_send']//following-sibling::img")
	WebElement show_excluded_invoices;

	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[@id='custpage_listheader']//following-sibling::tr//td[count(//td[@data-label='EMAIL TO']//preceding-sibling::td)+4]//textarea")
	List<WebElement> email_to;

	@FindBy(xpath = "//input[@name='inpt_custpage_emailtemplate']")
	WebElement email_template_input;

	@FindBy(xpath = "//div[@id='holdon-message']")
	WebElement hold_on_message;

	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[@id='custpage_listheader']//following-sibling::tr//td[count(//td[@data-label='DOCUMENT NUMBER']//preceding-sibling::td)+2]//a")
	List<WebElement> customer_link;

	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[@id='custpage_listheader']//following-sibling::tr//td[count(//td[@data-label='DOCUMENT NUMBER']//preceding-sibling::td)+2]//a//div")
	List<WebElement> customer_names_in_bei;

	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[@id='custpage_listheader']//following-sibling::tr//td[count(//td[@data-label='DOCUMENT NUMBER']//preceding-sibling::td)+2]")
	List<WebElement> customer_names;

	@FindBy(xpath = "//input[@name='custpage_multiattach_send']//following-sibling::img")
	WebElement multi_attach;

	@FindBy(xpath = "//table[@id='recmachcustrecord_tss_attach_to_tran__tab']//tbody//tr//td[count(//td[@data-label='EMAIL STATUS']//preceding-sibling::td)]")
	WebElement no_of_invoices_in_invoice;

	@FindBy(xpath = "//table[@id='recmachcustrecord_tss_attach_to_tran__tab']//tbody//tr//td[count(//td[@data-label='Include Customer Statement']//preceding-sibling::td)+1]")
	List<WebElement> customer_statement;

	@FindBy(xpath = "//input[@name='custpage_customerstatement_send']//following-sibling::img")
	WebElement include_customer_statement_checkbox;

	@FindBy(xpath = "//table[@id='messages__tab']//tbody//tr//td[count(//td[@data-label='Primary Recipient']//preceding-sibling::td)+1]")
	List<WebElement> email_ids_in_customer_record;

	@FindBy(xpath = "//td[@id='s_commlnk']")
	WebElement communication_tab;

	@FindBy(xpath = "//input[@name='custbody_tss_email_exclude_send']//following-sibling::img")
	WebElement exclude_invvoice;

	@FindBy(xpath = "//span[@id='entity_fs_lbl_uir_label']//following-sibling::Span")
	WebElement customer_name_in_invoice;

	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[@id='custpage_listheader']//following-sibling::tr//td[count(//td[@data-label='DATE']//preceding-sibling::td)]//span")
	List<WebElement> select_checkbox_checking;

	@FindBy(xpath = "//td[@id='tdbody_custpage_markall_btn']")
	WebElement mark_all;

	@FindBy(xpath = "//table//tr[contains(@id,'neg14051row')]//td[count(//td[@data-label='Customer']//preceding-sibling::td)+1]")
	List<WebElement> bei_comparison_customers;

	@FindBy(xpath = "//table//tr[contains(@id,'neg14051row')]//td[count(//td[@data-label='Number of email sent']//preceding-sibling::td)+1]")
	List<WebElement> no_of_emails_sent_through_bei;

	@FindBy(xpath = "//h2[@title='BEI Comparison After BEI']//following::td[@id='uir_totalcount']//a")
	WebElement total_count_bei;

	@FindBy(xpath = "//a[@aria-label='Dashboard']")
	WebElement dashboard;

	@FindBy(xpath = "//h2[@title='Total Amount Followed Up']")
	WebElement amount_followed_up_through;

	@FindBy(xpath = "//span[@id='email_fs_lbl_uir_label']//following-sibling::span")
	WebElement email_fiels_in_customer;

	@FindBy(xpath = "//span[@id='custentity_tss_bulk_email_addresses_fs_lbl_uir_label']//following-sibling::span")
	WebElement bulk_email_addresses;

	@FindBy(xpath = "//span[@id='email_fs_lbl_uir_label']//following-sibling::span")
	WebElement to_be_emailed;

	@FindBy(xpath = "//td[@id='outputlnk']")
	WebElement communication_tab_in_invoice;

	@FindBy(xpath = "//td[@id='cmmnctntablnk']")
	WebElement communication_tab_in_credit_memo;

	@FindBy(xpath = "//span[@id='email_fs_lbl_uir_label']//following-sibling::span")
	WebElement email_ids_in_credit_memo;

	@FindBy(xpath = "//input[@id='searchid']//preceding-sibling::td//a[@id='totallinkneg60']")
	WebElement total_invoices_followed_up;

	@FindBy(xpath = "//h2[@title='BEI Comparison Before BEI']//following::td[@id='uir_totalcount']//a")
	WebElement open_days_in_dashboard;

	@FindBy(xpath = "//table[@id='recmachcustrecord_tss_attach_to_tran__tab']//tbody//tr")
	List<WebElement> total_email_rows_in_bei_tab;

	@FindBy(xpath = "//a[@id='Transaction_NAME_popup_list']")
	WebElement name_popup_list;

	@FindBy(xpath = "//textarea[@name='CUSTRECORD_TSS_BEI_CUSTOMER_display']")
	WebElement customer_textarea;

	static AuthPageNavigation authPage;

	static String parentWindow;

	TestUtil util;
	@FindBy(xpath = "//table[@id='neg14050__tab']//tbody//td[count(//h2[@title='BEI Comparison Before BEI']//following::table[@id='neg14050__tab']//td[@data-label='Sum of Amount Remaining']//preceding-sibling::td)]//a")
	List<WebElement> Customer_open_days_in_bei;

	@FindBy(xpath = "//table[@id='neg14050__tab']//tbody//td[count(//h2[@title='BEI Comparison Before BEI']//following::table[@id='neg14050__tab']//td[@data-label='Maximum of Days Open']//preceding-sibling::td)+1]")
	List<WebElement> customer_open_days;

	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//td[count(//td[@data-label='Days Open']//preceding-sibling::td)+1]")
	List<WebElement> max_days_open_dashboard;

	@FindBy(xpath = "//h2[@title='BEI Comparison Before BEI']")
	WebElement bei_comparsion;

	@FindBy(xpath = "//li[@class='ns-menuitem ns-role-menuitem']//a//span[@class='ns-role-menuitem-text']")
	List<WebElement> beilink;

	@FindBy(xpath = "//li[@data-title='Setup']")
	WebElement setup;

	@FindBy(xpath = "//li[@data-title='Bulk Email Invoice']")
	WebElement bulk_email_invoice;

	@FindBy(xpath = "//li[@data-title='Configuration Page']")
	WebElement configuration_page;

	@FindBy(xpath = "//a//preceding::div[@id='spn_cRR_d1']")
	WebElement view_roles;

	@FindBy(xpath = "//table[@id='div__bodytab']//tr//td[count(//td[@data-label='Role']//preceding-sibling::td)+1]//a")
	List<WebElement> roles_;

	@FindBy(xpath = "//table[@id='div__bodytab']//tr//td[count(//td[@data-label='Account Type']//preceding-sibling::td)]")
	List<WebElement> company_name;

	@FindBy(xpath = "//table[@id='div__bodytab']//tr//td[count(//td[@data-label='Last Login']//preceding-sibling::td)]")
	List<WebElement> account_type;

	@FindBy(xpath = "//input[@id='inpt_custpage_emailtemplate1']")
	WebElement email_template_before;

	@FindBy(xpath = "//input[@id='inpt_custpage_emailtemplateaft2']")
	WebElement email_template_after;

	@FindBy(xpath = "//input[@id='custpage_daysbefore_formattedValue']")
	WebElement no_of_days_before_due_date;

	@FindBy(xpath = "//input[@id='custpage_daysafter_formattedValue']")
	WebElement no_of_days_after_due_date;

	@FindBy(xpath = "//input[@name='custpage_include_cs_send']//following-sibling::img")
	WebElement include_cus_stat_config;

	@FindBy(xpath = "//input[@name='custpage_opentransactions_send']//following-sibling::img")
	WebElement include_cus_stat_config_only_open;

	@FindBy(xpath = "//td[@id='tdbody_submitter']")
	WebElement submit_config;

	@FindBy(xpath = "//textarea[@name='Transaction_NAME_display']")
	WebElement search_text_area;

	@FindBy(xpath = "//a[@id='CUSTRECORD_TSS_BEI_CUSTOMER_popup_list']")
	WebElement customer_pop_up_link;

	@FindBy(xpath = "//img[@id='inpt_custpage_emailtemplate1_arrow']")
	WebElement before_email_arrow;

	@FindBy(xpath = "//img[@id='inpt_custpage_emailtemplateaft2_arrow']")
	WebElement after_email_arrow;

	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> dropdown_email_after_before;

	@FindBy(xpath = "//li[@data-title='Customization']")
	WebElement customization;

	@FindBy(xpath = "//li[@data-title='Scripting']")
	WebElement scripting;

	@FindBy(xpath = "//li[@data-title='Scripts']")
	WebElement scripts;

	// invoice web elements

	@FindBy(xpath = "//span[contains(text(),'Transactions')]")
	WebElement Transactions;

	@FindBy(xpath = "//li[@data-title='Sales']")
	WebElement sales;

	@FindBy(xpath = "//li[@data-title='Create Invoices']")
	WebElement create_invoices;

	@FindBy(xpath = "//li[@data-title='Create Invoices']//following::li[@data-title='List']")
	WebElement invoice_list;

	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//td[count(//td[@data-label='Status']//preceding-sibling::td)+1]")
	List<WebElement> status_in_invoice_list;

	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//td[count(//td[@data-label='Internal ID']//preceding-sibling::td)]//a[@class='dottedlink viewitem']")
	List<WebElement> view_in_invoice_list;

	@FindBy(xpath = "//td[@id='tdbody_edit']")
	WebElement edit_invoice;

	@FindBy(xpath = "//input[@id='duedate']")
	WebElement due_date_in_invoice_record;

	@FindBy(xpath = "//td[@id='spn_multibutton_submitter']")
	WebElement save_invoice;

	// script web elements

	@FindBy(xpath = "//td[@id='tdbody_edit']")
	WebElement script_edit;

	@FindBy(xpath = "//div[@class='bntBgT']")
	WebElement edit_expand;

	@FindBy(xpath = "//span[contains(text(),'Save and Execute')]")
	WebElement save_and_execute;

	@FindBy(xpath = "//table[@id='recmachcustrecord_tss_attach_to_tran__tab']//tbody//td[count(//td[@data-label='BULK EMAIL SEND DATE']//preceding-sibling::td)+1]")
	List<WebElement> bulk_email_send_date;

	@FindBy(xpath = "//img[@id='inpt_quicksort6_arrow']")
	WebElement recently_arrow;

	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> recenty_drop;

	@FindBy(xpath = "//span[@id='parent_fs_lbl_uir_label']")
	WebElement parent_company;

	@FindBy(xpath = "//span[@id='parent_fs_lbl_uir_label']//following-sibling::span//a")
	WebElement parent_company_value;

	@FindBy(xpath = "//td[@id='tdbody_acceptpayment']")
	WebElement accept_payment;

	@FindBy(xpath = "//span[@id='amountremainingtotalbox_fs_lbl_uir_label']//following-sibling::span")
	WebElement amount_due;

	@FindBy(xpath = "//span[@id='tranid_fs_lbl_uir_label']//following-sibling::span")
	WebElement reference_no_in_invoice;

	@FindBy(xpath = "//table[@id='apply_splits']//tr//following-sibling::tr//td[count(//td[@data-label='Orig. Amt.']//preceding-sibling::td)-7]")
	List<WebElement> ref_no_in_payment;

	@FindBy(xpath = "//table[@id='apply_splits']//tr//following-sibling::tr//td[count(//td[@data-label='Payment']//preceding-sibling::td)-3]")
	List<WebElement> payment_amount_click;

	@FindBy(xpath = "//td[@id='spn_secondarymultibutton_submitter']")
	WebElement payment_save;

	@FindBy(xpath = "//table[@id='apply_splits']//tr//following-sibling::tr//td[count(//td[@data-label='Payment']//preceding-sibling::td)-3]//input[@class='inputrt']")
	List<WebElement> payment_amount;

	@FindBy(xpath = "//li[@data-title='Lists']")
	WebElement Lists;

	@FindBy(xpath = "//li[@data-title='Custom']")
	WebElement custom;

	@FindBy(xpath = "//li[@data-title='Consolidate Customer Invoices']")
	WebElement consolidate_customer_invoice;

	@FindBy(xpath = "//table[@id='custpage_ci_invoices_splits']//tbody//tr//following-sibling::tr//td[count(//td[@data-label='Currency']//preceding-sibling::td)+1]")
	List<WebElement> consolidate_customer;

	@FindBy(xpath = "//table[@id='custpage_ci_invoices_splits']//tbody//tr//following-sibling::tr//td[count(//td[@data-label='AMount Due']//preceding-sibling::td)+1]")
	List<WebElement> consolidate_no_invoices;

	@FindBy(xpath = "//table[@id='custpage_ci_invoices_splits']//tbody//tr//following-sibling::tr//td[count(//td[@data-label='Number of Invoices']//preceding-sibling::td)]//img")
	List<WebElement> consolidate_invoice_checkbox;

	@FindBy(xpath = "//input[@id='custpage_duedate']")
	WebElement due_date_in_consolidation;

	@FindBy(xpath = "//td[@id='tdbody_submitter']")
	WebElement submit_consolidate;

	@FindBy(xpath = "//div[@class='descr']//a")
	WebElement consolidate_link;

	@FindBy(xpath = "//img[@id='inpt_quicksort3_arrow']")
	WebElement consolidate_arrow;

	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> consolidate_dropdown;

	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//tr//following-sibling::tr//td[count(//td[@data-label='Invoices']//preceding-sibling::td)]")
	List<WebElement> consolidate_customer_after;

	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//tr//following-sibling::tr//td[count(//td[@data-label='Invoices']//preceding-sibling::td)+1]")
	List<WebElement> consolidate_invoice_after;

	@FindBy(xpath = "//input[@name='custpage_opentransactions_send']//following-sibling::img")
	WebElement include_customer_open;

	@FindBy(xpath = "//input[@name='custpage_customerstatement_send']//following-sibling::img")
	WebElement include_customer;

	@FindBy(xpath = "//input[@name='inpt_custpage_pagination']")
	WebElement total_invoices_in_bei;

	@FindBy(xpath = "//input[@name='inpt_custpage_pagination']")
	WebElement page_arrow;

	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> page_dropdown;

	@FindBy(xpath = "//input[@name='inpt_Transaction_DEPARTMENT']")
	WebElement dept_in_search_arrow;

	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> dept_list_in_search;

	@FindBy(xpath = "//input[@name='inpt_Transaction_LOCATION']")
	WebElement location_arrow_in_search;

	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> location_list_in_search;

	@FindBy(xpath = "//input[@name='inpt_Transaction_NAME']")
	WebElement customer_arrow_in_search;

	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> customer_list_in_search;

	@FindBy(xpath = "//input[@name='Transaction_TRANDATEfrom']")
	WebElement from_date_in_search;

	@FindBy(xpath = "//input[@name='Transaction_TRANDATEto']")
	WebElement to_date_in_search;

	@FindBy(xpath = "//span[@aria-label='Expand/Collapse filters']")
	WebElement expand_collapse_in_search;

	@FindBy(xpath = "//table[@id='div__bodytab']//tr[contains(@class,'uir-list-row-tr')]//td[count(//td[@data-label='Invoice Number']//preceding-sibling::td)+1]//a")
	List<WebElement> doc_nr_in_search;

	@FindBy(xpath = "//input[@name='inpt_Transaction_CLASS']")
	WebElement class_arrow_in_search;

	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> class_list_in_search;

	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> dropdown_in_bei;

	@FindBy(xpath = "//span[@id='entity_fs_lbl_uir_label']//following-sibling::span//a")
	WebElement customer_in_invoice;

	@FindBy(xpath = "//span[@id='tranid_fs_lbl_uir_label']//following-sibling::span")
	WebElement invoice_nr_in_invoice;

	@FindBy(xpath = "//table[@id='messages__tab']//tbody//tr//td[count(//td[@data-label='Internal Only']//preceding-sibling::td)]")
	List<WebElement> attachments_in_customer_record;

	@FindBy(xpath = "//table[@id='messages__tab']//tbody//tr//td[count(//td[@data-label='Subject']//preceding-sibling::td)+1]")
	List<WebElement> template_in_customer_record;

	@FindBy(xpath = "//table[@id='messages__tab']//tbody//tr//td[3]")
	List<WebElement> dates_in_customer_record;

	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//tr[contains(@class,'uir-list-row-tr')]//td[count(//td[@data-label='Status']//preceding-sibling::td)+1]")
	List<WebElement> script_status;

//	@FindBy(xpath="//input[@id='custpage_refresh']")
//	List<WebElement> ref;
//	
	JavascriptExecutor js = (JavascriptExecutor) driver;

	String confirm_message = null;
	String confirm_not = null;
	String date_validations_message = null;
	AuthPageNavigation authpage;

	public BEI_functions() {
		PageFactory.initElements(driver, this);
	}

	public void navigate_to_consolidate_customer_invoice() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(Lists).build().perform();
		Thread.sleep(2000);
		if (arrow.isDisplayed()) {
			arrow.click();
		}
		if (arrow.isDisplayed()) {
			arrow.click();
		}
		Thread.sleep(3000);
		action.moveToElement(custom).build().perform();
		Thread.sleep(2000);
		consolidate_customer_invoice.click();
	}

	public void required_account(String role, String company, String account) throws InterruptedException {
		Actions action = new Actions(driver);
		view_roles.click();
		Thread.sleep(5000);
		for (int i = 0; i < roles_.size(); i++) {
			WebElement role_index = roles_.get(i);
			String role_text = role_index.getText();
			WebElement account_index = account_type.get(i + 1);
			String account_text = account_index.getText();
			WebElement company_index = company_name.get(i + 1);
			String company_text = company_index.getText();
			if (role_index.getText().trim().equals(role) && company_index.getText().trim().equals(company)
					&& account_index.getText().trim().equals(account)) {
				System.out.println("role is " + role_index.getText());
				System.out.println("account is " + account_index.getText());
				System.out.println("company is " + company_index.getText());
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", role_index);
				role_index.click();
				break;

			}
		}
	}

	public static void windowHandle() throws Exception {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String currentwindow = driver.getWindowHandle();
		parentWindow = currentwindow;
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> i = allWindows.iterator();
		while (i.hasNext()) {
			String childwindow = i.next();
			if (!childwindow.equalsIgnoreCase(currentwindow)) {
				driver.switchTo().window(childwindow);
			}
		}
	}

	public void selectcustomer(String customer_name) throws InterruptedException {
		customer_arrow.click();
		pop_up_list.click();
		input_customer.sendKeys(customer_name);
		search_customer.click();
		Thread.sleep(7000);
		for (int i = 0; i < customer_list.size(); i++) {
			System.out.println(customer_list.get(i).getText());
			if (customer_list.get(i).getText().trim().equals(customer_name.trim())) {
				customer_list.get(i).click();
				Thread.sleep(5000);
				break;
			}
		}
	}

	public void from_to_date(String from_date, String to_date) throws InterruptedException {
		form_date.clear();
		form_date.sendKeys(from_date);
		Thread.sleep(2000);
		this.to_date.clear();
		this.to_date.sendKeys(to_date);
		Thread.sleep(2000);
	}

	public void filters(String filter, WebElement arrow, List<WebElement> list, String testcase, ExtentTest test,
			String fromdate, String todate) throws InterruptedException {
		List<String> invoice_number_in_bei = new ArrayList<String>();
		for (int i = 0; i < doc_nr.size(); i++) {
			invoice_number_in_bei.add(doc_nr.get(i).getText());
		}
		driver.navigate()
				.to("https://tstdrv939179-rp.app.netsuite.com/app/common/search/searchresults.nl?searchid=535&whence=");
		if (driver.findElement(By.xpath("//span[@aria-label='Expand/Collapse filters']")).getAttribute("aria-expanded")
				.equals("false")) {
			expand_collapse_in_search.click();
		}
		arrow.click();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equals(filter.trim())) {
				list.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		from_date_in_search.sendKeys(fromdate);
		to_date_in_search.click();
		Thread.sleep(5000);
//		to_date_in_search.sendKeys(todate);
//		Thread.sleep(5000);
//		from_date_in_search.click();
//		WebDriverWait wait=new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.visibilityOf(doc_nr_in_search.get(0)));
		List<String> invoice_nr_in_search = new ArrayList<String>();
		for (int i = 0; i < doc_nr_in_search.size(); i++) {
			invoice_nr_in_search.add(doc_nr_in_search.get(i).getText().replace("Invoice #", ""));
		}
		Collections.sort(invoice_nr_in_search);
		Collections.sort(invoice_number_in_bei);
		System.out.println("invoice_nr_in_search " + invoice_nr_in_search);
		System.out.println("invoice_number_in_bei " + invoice_number_in_bei);
		if (invoice_nr_in_search.equals(invoice_number_in_bei)) {

			if (testcase.trim().equals("invoices related to particular department")) {
				test.pass("Invoices are displayed correctly for a given department");
				System.out.println("Invoices are displayed correctly for a given department");
			}
			if (testcase.trim().equals("Invoices related to particular location")) {
				test.pass("Invoices are displayed correctly for given location");
				System.out.println("Invoices are displayed correctly for given location");
			}
			if (testcase.trim().equals("invoices of a particular customer")) {
				test.pass("Invoices are displayed correctly for given customer");
				System.out.println("Invoices are displayed correctly for given customer");
			}
			if (testcase.trim().equals("Invoices related to particular class")) {
				test.pass("Invoices are displayed correctly for given class");
				System.out.println("Invoices are displayed correctly for given class");
			}
		} else {
			test.fail(filter + " filter is not working");
			System.out.println(filter + " filter is not working");
		}
	}

	@SuppressWarnings("unused")
	public void date_range_invoices(String from_date1, String to_date1, String testcase, String customer_name1,
			String department1, String class1, String location1, String email_ids, String email2, ExtentTest test)
			throws Exception {
		required_role("BEI-AR", "Tvarana Dev Production");
		authpage = new AuthPageNavigation();
		authpage.navigatetoBEI();
		if (testcase.trim().equals("multiple invoices to multiple email ids")) {

			from_to_date(from_date1, to_date1);
			search_button.click();
			Thread.sleep(3000);
			email_template_input.sendKeys("Invoice Email Template");
			unmark_all.click();
			Thread.sleep(5000);
			// js.executeScript("arguments[0].scrollIntoView(true);",doc_nr.get(0));
			int count = 0;
			String first_customer_url = "";
			String second_customer_url = "";
			String selectLinkOpeninNewTab1 = Keys.chord(Keys.CONTROL, Keys.ENTER);
			for (int i = 0; i < doc_nr.size(); i++) {
				if (count == 2)
					break;
				WebElement email_index = email_to.get(i);
				char c = email_index.getText().charAt(0);
				boolean empty_or_not = false;
				if (c == ' ') {
					empty_or_not = true;
				}
				if (empty_or_not) {
					if (count != 1) {
						select_invoices.get(i).click();
						email_to.get(i).sendKeys(email_ids.trim());
						customer_link.get(i).sendKeys(selectLinkOpeninNewTab1);
						windowHandle();
						first_customer_url = driver.getCurrentUrl();
						driver.close();
						Thread.sleep(2000);
						driver.switchTo().window(parentWindow);
						Thread.sleep(4000);
					}
					if (count == 1) {
						select_invoices.get(i).click();
						email_to.get(i).sendKeys(email2);
						customer_link.get(i).sendKeys(selectLinkOpeninNewTab1);
						windowHandle();
						second_customer_url = driver.getCurrentUrl();
						driver.close();
						Thread.sleep(2000);
						driver.switchTo().window(parentWindow);
					}

				}
				count = count + 1;

			}
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-800)", "");
			Thread.sleep(2000);
			process_button.click();
			Thread.sleep(3000);
			refresh_until_process();
			String first_date = "";
			String second_date = "";
			String first_emails = "";
			String second_emails = "";
			if (first_customer_url.equals(second_customer_url)) {

				driver.navigate().to(first_customer_url);
				communication_tab.click();
				first_date = dates_in_customer_record.get(0).getText().trim();
				System.out.println("first date: " + first_date);
				second_date = dates_in_customer_record.get(1).getText().trim();
				System.out.println("second date: " + second_date);
				first_emails = email_ids_in_customer_record.get(0).getText().trim();
				System.out.println("first email: " + first_emails);
				second_emails = email_ids_in_customer_record.get(1).getText();
				System.out.println("second emails: " + second_emails);
				if (first_date.equals(second_date) && first_emails.replace("; ", ",").equals(email2)
						&& second_emails.replace("; ", ",").equals(email_ids)) {
					test.pass("Multiple invoices are sent to multiple email ids");
					System.out.println("Multiple invoices are sent to multiple email id's");

				}

			} else {
				driver.navigate().to(first_customer_url);
				communication_tab.click();
				first_date = dates_in_customer_record.get(0).getText().trim();
				System.out.println("first date: " + first_date);

				first_emails = email_ids_in_customer_record.get(0).getText().trim();
				System.out.println("first email: " + first_emails);
				driver.navigate().to(second_customer_url);

				second_date = dates_in_customer_record.get(0).getText().trim();
				System.out.println("second date: " + second_date);

				second_emails = email_ids_in_customer_record.get(0).getText();
				System.out.println("second emails: " + second_emails);
				if (first_date.equals(second_date) && first_emails.replace("; ", ",").equals(email2)
						&& second_emails.replace("; ", ",").equals(email_ids)) {
					test.pass("Multiple invoices are sent to multiple email ids");
					System.out.println("Multiple invoices are sent to multiple email id's");

				}

			}

		}
		if (testcase.trim().equals("include customer statement with and without open transactions")) {
			String[] count = new String[2];
			String[] count1 = new String[2];
			String total = null;
			from_to_date(from_date1, to_date1);
			include_customer_open.click();
			search_button.click();
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", multi_attach);
			@SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, 50);
			total = driver.findElement(By.xpath("//input[@name='inpt_custpage_pagination']")).getAttribute("value")
					.trim();
			for (int i = 0; i < count.length; i++) {
				count = total.split("of ");
			}
			System.out.println(
					"The total number of invoices for customer statement without open invoices is " + count[1]);
			js.executeScript("window.scrollTo(0,0)");
			Thread.sleep(3000);
			from_to_date(from_date1, to_date1);
			if (driver.findElement(By.xpath("//span[@id='custpage_paidinfull_fs']")).getAttribute("class")
					.contains("checkbox_ck")) {
				show_only_open_invoices.click();
			}
			include_customer.click();
			search_button.click();
			Thread.sleep(5000);
			js.executeScript("arguments[0].scrollIntoView(true);", multi_attach);
			wait.until(ExpectedConditions.visibilityOf(page_arrow));
			String total1 = null;
			total1 = driver.findElement(By.xpath("//input[@name='inpt_custpage_pagination']")).getAttribute("value")
					.trim();
			Thread.sleep(2000);
			for (int i = 0; i < count1.length; i++) {
				count1 = total1.split("of ");
			}
			System.out.println(
					"The total number of invoices for customer statement without open invoices is " + count1[1]);
			int open_count = Integer.parseInt(count[1]);
			int open_full_count = Integer.parseInt(count1[1]);
			if (open_full_count > open_count) {
				System.out.println(
						"Transactions displayed in Customer Statement on checking Customer Statement are more than transactions displayed in Customer Statement on checking Customer Statement(Open Transactions)");
				test.pass(
						"Transactions displayed in Customer Statement on checking Customer Statement are more than transactions displayed in Customer Statement on checking Customer Statement(Open Transactions)");
			} else {
				System.out.println(
						"Transactions displayed in Customer Statement on checking Customer Statement are not more than transactions displayed in Customer Statement on checking Customer Statement(Open Transactions)");
				test.fail(
						"Transactions displayed in Customer Statement on checking Customer Statement are not more than transactions displayed in Customer Statement on checking Customer Statement(Open Transactions)");
			}

		}
		if (testcase.trim().equals("Invalid Email Template")) {
			search_button.click();
			email_template_input.sendKeys("Checkout Errors 10/15/18 11:44:20 PM");
			process_button.click();
			if (isAlertPresent_() == true) {
				Alert alert = driver.switchTo().alert();
				confirm_message = alert.getText();
				alert.accept();
				System.out.println("The error message is " + confirm_message);
				test.pass("The error message is " + confirm_message);
			} else {
				confirm_not = "Alert message is not displaying when we select invalid email template";
				System.out.println(confirm_not);
				test.fail(confirm_not);
			}
		}

		if (testcase.equals("invoices of a particular customer")) {
			int count = 0;
			from_to_date(from_date1, to_date1);
			selectcustomer(customer_name1.trim());
			search_button.click();
			filters(customer_name1, customer_arrow_in_search, customer_list_in_search, testcase, test, from_date1,
					to_date1);

		}
		if (testcase.equals("invoices related to particular department")) {
			from_to_date(from_date1, to_date1);
			department.sendKeys(department1.trim());
			search_button.click();
			filters(department1.trim(), dept_in_search_arrow, dept_list_in_search,
					"invoices related to particular department", test, from_date1, to_date1);

		}
		if (testcase.trim().equals("Invoices related to particular class")) {
			from_to_date(from_date1, to_date1);
			classs.sendKeys(class1.trim());
			search_button.click();
			filters(class1.trim(), class_arrow_in_search, class_list_in_search, testcase, test, from_date1, to_date1);
		}
		if (testcase.equals("Invoices related to particular location")) {

			from_to_date(from_date1, to_date1);
			location.sendKeys(location1.trim());
			search_button.click();
			filters(location1, location_arrow_in_search, location_list_in_search, testcase, test, from_date1, to_date1);

		}

		if (testcase.trim().equals("show only open invoices checkbox")) {
			if (driver.findElement(By.xpath("//span[@id='custpage_paidinfull_fs']")).getAttribute("class")
					.contains("checkbox_ck")) {
				System.out.println("open invoices is checked");
			} else {
				show_only_open_invoices.click();
				System.out.println("checked");
			}
			from_to_date(from_date1, to_date1);
			search_button.click();
			int count = 0;
			for (int i = 0; i < open_status.size(); i++) {
				WebElement open_index = open_status.get(i);
				if (open_index.getText().equals("Open")) {
					count = count + 1;
				}
				if (count == open_status.size()) {
					System.out.println("Invoices are displayed with Status Open only");
					test.pass("Invoices are displayed with Status Open only");
				}
			}
		}
		if (testcase.trim().equals("show only open invoices with credit memos")) {
			int open_invoice_count = 0;
			int credit_memos_count = 0;
			if (driver.findElement(By.xpath("//span[@id='custpage_showcreditmemos_fs']")).getAttribute("class")
					.contains("checkbox_unck")) {
				credit_memos.click();
			}
			from_to_date(from_date1, to_date1);
			search_button.click();
			for (int i = 0; i < tran_type.size(); i++) {
				WebElement tran_index = tran_type.get(i);
				if (tran_index.getText().equals("Invoice")) {
					open_invoice_count = open_invoice_count + 1;
				}
				if (tran_index.getText().equals("Credit Memo")) {
					credit_memos_count = credit_memos_count + 1;
				}
			}
			if (open_invoice_count > 0 && credit_memos_count > 0) {
				if (open_invoice_count + credit_memos_count == tran_type.size()) {
					System.out.println(
							"Invoices and credit memos are dislayed correctly by selecting show only open invoices with credit memos checkbox");
					test.pass(
							"Invoices and credit memos are dislayed correctly by selecting show only open invoices with credit memos checkbox");
				}
			} else {
				System.out.println(
						"Invoices and credit memos are not displayed correctly by selecting show only open invoices with credit memos checkbox");
				test.fail(
						"Invoices and credit memos are not displayed correctly by selecting show only open invoices with credit memos checkbox");
			}

		}

		
		if (testcase.trim().equals("sending email without invoices")) {

			from_to_date(from_date1, to_date1);
			search_button.click();
			email_template_input.sendKeys("Invoice Email Template");
			unmark_all.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-800)", "");
			process_button.click();
			Thread.sleep(5000);
			if (isAlertPresent_() == true) {
				Alert alert = driver.switchTo().alert();
				confirm_message = "Error message is " + alert.getText();
				alert.accept();
				System.out.println(confirm_message);
				test.pass(confirm_message);
			} else {
				System.out.println("Alert message is not displaying when we send email without invoices");
				test.fail("Alert message is not displaying when we send email without invoices");
			}

		}
		if (testcase.trim().equals("sending email without template")) {
			from_to_date(from_date1, to_date1);
			process_button.click();
			Thread.sleep(5000);
			if (isAlertPresent_() == true) {
				Alert alert = driver.switchTo().alert();
				System.out.println("Error message is " + alert.getText());
				test.pass("Error message is " + alert.getText());
				alert.accept();
			} else {
				System.out.println("Alert message is not displaying when we send email without selecting template");
				test.fail("Alert message is not displaying when we send email without selecting template");
			}

		}
		if (testcase.trim().equals("sending multi attach email")) {
			String customer_url = null;
			String invoice_url = null;
			String doc_texttt = null;
			int count = 0, count_empty = 0;
			from_to_date(from_date1, to_date1);
			selectcustomer(customer_name1.trim());
			Thread.sleep(2000);
			search_button.click();
			Thread.sleep(2000);
			email_template_input.sendKeys("Invoice Email Template");
			multi_attach.click();
			Thread.sleep(1000);
			unmark_all.click();
			for (int i = 0; i < email_to.size(); i++) {
				if (count == 2)
					break;
				System.out.println(email_to.size());
				WebElement email_index = email_to.get(i);
				char c = email_index.getText().charAt(0);
				boolean empty_or_not = false;
				if (c == ' ') {
					empty_or_not = true;
				}
				if (empty_or_not) {
					count_empty = count_empty + 1;
				} else {

					count = count + 1;
					WebElement doc_text = doc_nr.get(i);
					doc_texttt = doc_text.getText();
					select_invoices.get(i).click();
				}

			}
			System.out.println("count is " + count);
			System.out.println("count_empty is " + count_empty);
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,0)");
			Thread.sleep(2000);
			process_button.click();
			// Thread.sleep(5000);
			refresh_until_process();
			Thread.sleep(3000);
			@SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//input[@name='custpage_resendemail_send']//following-sibling::img")));
			show_emailed_invoices.click();
			search_button.click();
			for (int i = 0; i < doc_nr.size(); i++) {
				WebElement doc_index = doc_nr.get(i);
				if (doc_index.getText().equals(doc_texttt)) {
					System.out.println("show only emailed invoices checkbox is verified");
					//test.pass("Show only Emailed invoices checkbox functionality is verified");
					String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
					doc_index.sendKeys(selectLinkOpeninNewTab);
					windowHandle();
					bulk_email_invoices_tab.click();
					Thread.sleep(2000);
					String no_of_invoices = no_of_invoices_in_invoice.getText();
					int invoices = Integer.parseInt(no_of_invoices);
					if (invoices > 1) {
						System.out.println("Multi attach email funcitonality is working");
						test.pass("Multi attach email funcitonality is working");
					} else {
						System.out.println("Multi attach email functionality is not working");
						test.fail("Multi attach email functionality is not working");
					}

				}
			}
		}
		if (testcase.trim().equals("sending email to customer without email ids")) {
			Actions action = new Actions(driver);
			from_to_date(from_date1, to_date1);
			search_button.click();
			email_template_input.sendKeys("Invoice Email Template");
			unmark_all.click();
			Thread.sleep(3000);
			select_invoices.get(0).click();
			Thread.sleep(2000);
			String selectAll = Keys.chord(Keys.CONTROL, "a");
			email_to.get(0).click();
			Thread.sleep(500);
			email_to.get(0).sendKeys(selectAll);
			Thread.sleep(2000);
			action.sendKeys(Keys.BACK_SPACE).build().perform();
			Thread.sleep(1000);
			js.executeScript("window.scrollTo(0,0)");
			Thread.sleep(3000);
			process_button.click();
			Thread.sleep(5000);
			if (isAlertPresent_() == true) {
				Alert alert = driver.switchTo().alert();
				System.out.println("Error message is " + alert.getText());
				test.pass("Error message is " + alert.getText());
				alert.accept();
			} else {
				System.out.println("Alert Message is not displaying when we are sending email without email id's");
				test.fail("Alert Message is not displaying when we are sending email without email id's");
			}
		}
		if (testcase.trim().equals("sending email to customer with invalid email ids")) {
			from_to_date(from_date1, to_date1);
			search_button.click();
			email_template_input.sendKeys("Invoice Email Template");
			Thread.sleep(2000);
			unmark_all.click();
			Thread.sleep(5000);
			email_to.get(0).click();
			Actions action = new Actions(driver);
			String selectAll = Keys.chord(Keys.CONTROL, "a");
			Thread.sleep(1000);
			email_to.get(0).sendKeys(selectAll);
			Thread.sleep(2000);
			action.sendKeys(Keys.BACK_SPACE).build().perform();
			Thread.sleep(1000);
			email_to.get(0).sendKeys("sindhu@123");

			if (isAlertPresent() == true) {
				Alert alert = driver.switchTo().alert();
				test.pass("Error message is: " + alert.getText());
				alert.accept();
			} else {
				test.fail("Alert is not displaying");
				System.out.println("Alert is not displaying");
			}
			Thread.sleep(3000);
			email_to.get(0).click();
			Thread.sleep(1000);
			email_to.get(0).sendKeys(selectAll);
			Thread.sleep(2000);
			action.sendKeys(Keys.BACK_SPACE).build().perform();
			Thread.sleep(1000);

		}
		if (testcase.trim().equals("sending email with template")) {
			String customer_url = null;
			String invoice_url = null;
			String doc_texttt = null;
			int count = 0, count_empty = 0;
			int count_before = 0;
			int count_after = 0;
			from_to_date(from_date1, to_date1);
			search_button.click();
			email_template_input.sendKeys("Invoice Email Template");
			unmark_all.click();
			for (int i = 0; i < email_to.size(); i++) {
				if (count == 1)
					break;
				System.out.println(email_to.size());
				WebElement email_index = email_to.get(i);
				char c = email_index.getText().charAt(0);
				boolean empty_or_not = false;
				if (c == ' ') {
					empty_or_not = true;
				}
				if (empty_or_not) {
					count_empty = count_empty + 1;
				} else {
					count = count + 1;
					String selectLinkOpeninNewTab1 = Keys.chord(Keys.CONTROL, Keys.ENTER);
					customer_link.get(i).sendKeys(selectLinkOpeninNewTab1);
					windowHandle();
					customer_url = driver.getCurrentUrl();
					driver.close();
					driver.switchTo().window(parentWindow);
					String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
					doc_nr.get(i).sendKeys(selectLinkOpeninNewTab);
					windowHandle();
					invoice_url = driver.getCurrentUrl();
					driver.close();
					driver.switchTo().window(parentWindow);
					WebElement doc_text = doc_nr.get(i);
					doc_texttt = doc_text.getText();
					select_invoices.get(i).click();
				}

			}
			System.out.println("count is " + count);
			System.out.println("count_empty is " + count_empty);
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,0)", "");
			Thread.sleep(2000);
			process_button.click();
			WebDriverWait wait = new WebDriverWait(driver, 60);
			refresh_until_process();
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//input[@name='custpage_resendemail_send']//following-sibling::img")));
			show_emailed_invoices.click();
			Thread.sleep(3000);
			search_button.click();
			int count1 = 0;
			Thread.sleep(2000);
			for (int i = 0; i < doc_nr.size(); i++) {
				WebElement doc_index = doc_nr.get(i);
				if (doc_index.getText().equals(doc_texttt)) {
					String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
					doc_nr.get(i).sendKeys(selectLinkOpeninNewTab);
					windowHandle();
					bulk_email_invoices_tab.click();
					if (email_status_in_invoice.getText().equals("COMPLETED")) {
						System.out.println(
								"Emailed invoices are displayed correctly by selecting show emailed invoices checkbox");
						ExtentTest test1 = test.createNode("Show only Emailed invoice checkbox functionality testing");
						test1.pass(
								"Emailed invoices are displayed correctly by selecting show emailed invoices checkbox");
					}
					System.out.println("Sending email with selecting template is working");
					ExtentTest test2 = test.createNode("Sending email with selecting template testing");
					test2.pass("Sending email with selecting template is working");
					break;
				} else {
					count1 = count1 + 1;
					if (count1 == doc_nr.size()) {
						System.out.println(confirm_not);
						test.fail("Emailed invoice is not displayed");
					}
				}
			}

		}
		if (testcase.trim().equals("resending email")) {
			String customer_url = null;
			String invoice_url = null;
			String doc_texttt = null;
			int count = 0, count_empty = 0;
			from_to_date(from_date1, to_date1);
			show_emailed_invoices.click();
			search_button.click();
			Thread.sleep(5000);
			email_template_input.sendKeys("Invoice Email Template");
			unmark_all.click();
			int count_before = 0;
			int count_after = 0;
			for (int i = 0; i < email_to.size(); i++) {
				if (count == 1)
					break;
				System.out.println(email_to.size());
				WebElement email_index = email_to.get(i);
				char c = email_index.getText().charAt(0);
				boolean empty_or_not = false;
				if (c == ' ') {
					empty_or_not = true;
				}
				if (empty_or_not) {
					count_empty = count_empty + 1;
				} else {
					count = count + 1;
					WebElement doc_text = doc_nr.get(i);
					doc_texttt = doc_text.getText();
					String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
					doc_nr.get(i).sendKeys(selectLinkOpeninNewTab);
					windowHandle();
					invoice_url = driver.getCurrentUrl();
					bulk_email_invoices_tab.click();
					System.out.println("Count of emails before resending is " + total_email_rows_in_bei_tab.size());
					test.pass("Count of emails before resending is " + total_email_rows_in_bei_tab.size());
					if (total_email_rows_in_bei_tab.size() > 0) {
						ExtentTest test1 = test.createNode(" Verifying Email details in Bulk Email Invoices Tab");
						test1.pass("Email details are displaying in Bulk Email Invoices Tab");
					}
					for (int j = 0; j < total_email_rows_in_bei_tab.size(); j++)

					{
						count_before = total_email_rows_in_bei_tab.size();
					}
					driver.switchTo().window(parentWindow);
					select_invoices.get(i).click();
				}

			}
			@SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, 60);
			System.out.println("count is " + count);
			System.out.println("count_empty is " + count_empty);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,0)");
			wait.until(ExpectedConditions.visibilityOf(process_button));
			process_button.click();
			Thread.sleep(3000);
			refresh_until_process();
			Thread.sleep(2000);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.xpath("//input[@name='custpage_resendemail_send']//following-sibling::img")));
			driver.navigate().to(invoice_url);
			Thread.sleep(5000);
			bulk_email_invoices_tab.click();
			count_after = total_email_rows_in_bei_tab.size();
			System.out.println("Count of email's after resending email is " + count_after);
			test.pass("Count of email's after resending email is " + count_after);
			if (count_after > count_before) {
				System.out.println("Resend email is working");
				test.pass("Resend email is working");
			} else {
				System.out.println("Resend Email is not working");
				test.fail("Resend Email is not working");
			}
		}

	}

	public boolean isAlertPresent_() {
		try {
			Alert a = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
			if (a != null) {
				System.out.println("Alert is present");
				return true;
			} else {
				throw new Throwable();
			}
		} catch (Throwable e) {
			System.err.println("Alert isn't present!!");
			return false;
		}

	}

	public boolean isAlertPresent() throws InterruptedException {

		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		if (isAlertPresent_() == true) {
			return true;
		} else {

			return false;
		}
	}

	public void verify_date_validations(ExtentTest test, String alert_text) {

		test.pass(alert_text);
	}

	public void date_Alert(ExtentTest test, String type) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		if (isAlertPresent_() == true) {
			Alert alert = driver.switchTo().alert();
			test.pass("Date entered is " + type + ": " + alert.getText());
			alert.accept();
		} else {
			test.fail("Alert is not displaying");
		}
	}

	public void date_validations(String alphabets, String special_chars, String alpha_numerics,
			String alpha_special_chars, String numbers_special_chars, String testcase,
			String to_date_less_than_three_digits, String to_date_greater_than_two_digits, String from_date,
			String to_date2, String due_date, ExtentTest test) throws InterruptedException, ParseException {
		authpage = new AuthPageNavigation();
		authpage.navigatetoBEI();
		String alert_message = null;
		DateFormat df = new SimpleDateFormat("M/d/yyyy");
		Actions action = new Actions(driver);
		if (testcase.trim().equals("invoices within due date")) {
			Date uiMin = null, uiMax = null, baseMin, baseMax, baseFrom;
			from_to_date(from_date, to_date2);
			due_datee.sendKeys(due_date);
			show_only_open_invoices.click();
			search_button.click();
			int count = 0;
			String due_date_to_test = due_datee.getText().trim();
			System.out.println("Due date from bei screen is: " + due_date_to_test);
			baseMin = df.parse(due_date);
			System.out.println(baseMin);
			baseMax = new SimpleDateFormat("M/d/yyyy").parse(due_date);
			baseFrom = new SimpleDateFormat("M/d/yyyy").parse(from_date);
			Date baseTo = new SimpleDateFormat("M/d/yyy").parse(to_date2.trim());
			int n = invoices_date_range_dates.size();
			SimpleDateFormat formatter1 = new SimpleDateFormat("M/d/yyy");

			String min1 = invoices_date_range_dates.get(0).getText();
			uiMin = formatter1.parse(min1);

			String max1 = invoices_date_range_dates.get(n - 1).getText();
			uiMax = formatter1.parse(max1);

			for (int i = 0; i < n; i++) {
				WebElement dateIndex = invoices_date_range_dates.get(i);
//				if(dateIndex.getText().trim().equals(due_date.trim()))
//				{
//					count=count+1;
//					System.out.println("The due dates that matches with given due date is: "+dateIndex.getText()+" "+count);
//				}

				if ((uiMax.before(baseTo) && uiMin.after(baseFrom))
						|| formatter1.parse(dateIndex.getText().trim()).equals(formatter1.parse(due_date))
								&& (uiMax.before(baseTo) && uiMin.after(baseFrom))) {

					count = count + 1;
				}
				if (count == n) {
					System.out.println("Invoices are displayed correctly within given duedate");
					test.pass("Invoices are displayed correctly within given duedate");
				}
			}
			System.out.println("count is: " + count);
			if (count != n) {

				System.out.println(
						"There is no invoice within that due date... please try with other due date (or) invoices are not displayed correctly within the given due date");
				test.fail(
						"There is no invoice within that due date... please try with other due date (or) invoices are not displayed correctly within the given due date");
			}
		}
		if(testcase.trim().equals("invoices with subsidiary"))
		{
			test.pass("Account is not a one world account");
		}
		
		if (testcase.trim().equals("due date greater than from and to date")) {
			due_datee.clear();
			due_datee.sendKeys(due_date);
			if (isAlertPresent() == true) {
				Alert alert = driver.switchTo().alert();
				test.pass("Error message is:" + alert.getText());
				System.out.println(alert.getText());
				alert.accept();
			} else {
				test.fail("Alert is not displaying");
				System.out.println("Alert is not displaying");
			}
		}
		if (testcase.trim().equals("from date greater than to date")) {
			Thread.sleep(3000);
			form_date.clear();
			Thread.sleep(3000);
			form_date.sendKeys(from_date.trim());
			action.sendKeys(Keys.TAB).build().perform();
			if (isAlertPresent_() == true) {
				Alert alert = driver.switchTo().alert();
				confirm_message = "The error message is " + alert.getText();
				test.pass("The error message is " + alert.getText());
				System.out.println("Error message is " + alert.getText());
				alert.accept();
			} else {
				System.out.println("Alert is not displaying");
				test.fail("Alert message is not displaying");
			}
		}
		if (testcase.equals("invoices within date range")) {
			Date uiMin = null, uiMax = null, baseMin, baseMax;
			from_to_date(from_date.trim(), to_date2.trim());
			search_button.click();
			baseMin = new SimpleDateFormat("MM/dd/yyyy").parse(from_date);
			baseMax = new SimpleDateFormat("MM/dd/yyyy").parse(to_date2);
			int n = invoices_date_range_dates.size();
			SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy");
			String min1 = invoices_date_range_dates.get(0).getText().trim();
			uiMin = formatter1.parse(min1);
			String max1 = invoices_date_range_dates.get(n - 1).getText().trim();
			uiMax = formatter1.parse(max1);
			int count = 0;
			for (int i = 0; i < n; i++) {
				String dateIndex = invoices_date_range_dates.get(i).getText();
				Date dateString = new SimpleDateFormat("MM/dd/yyyy").parse(dateIndex);

				if (uiMin.after(baseMin) && uiMax.before(baseMax) || uiMin.after(baseMin) && uiMax.before(baseMax)
						&& uiMin.equals(dateString) && uiMax.equals(dateString)) {
					count = count + 1;
				}

			}

			if (count == n) {
				System.out.println("Invoices are correctly displayed within the given date range");
				test.pass("Invoices are correctly displayed within the given date range");
			} else {
				System.out.println("Invoices are not displayed correctly within the given date range ");
				test.fail("Invoices are not displayed correctly within the given date range ");
			}

		}
		if(testcase.trim().equals("Date value greater than 31"))
		{
			test.fail("System is not displaying the highest day in the given month");
		}
		if (testcase.trim().equals("Month value greater than 13")) {
			Thread.sleep(5000);
			from_to_date(from_date, to_date2);
			customer_name.click();
			String tdate_text = to_date.getAttribute("value");
			System.out.println("to date is " + tdate_text);
			String fdate_text = form_date.getAttribute("value");
			System.out.println("from date is " + fdate_text);
			String[] highest_from_month = fdate_text.split("/");
			for (int i = 0; i < highest_from_month.length; i++) {
				System.out.println("dates are after splitting " + highest_from_month[i]);
			}
			String[] highest_to_month = tdate_text.split("/");
			for (int j = 0; j < highest_to_month.length; j++) {
				System.out.println("dates after splitting " + highest_to_month[j]);
			}
			if ((highest_from_month[0].equals("12")) && (highest_to_month[0].equals("12"))) {
				confirm_message = "Month value is taking as highest month value when we give month value greater than 12";
				System.out.println(
						"Month value is taking as highest month value when we give month value greater than 12");
				test.pass(confirm_message);
			} else {
				confirm_not = "Month value is not taking as highest month value when we give month value greater than 12";
				System.out.println(confirm_not);
				test.fail(confirm_not);
			}
		}
		if (testcase.equals("without giving from date and to date")) {
			Thread.sleep(5000);
			to_date.clear();
			Thread.sleep(1000);
			form_date.clear();
			Thread.sleep(1000);
			search_button.click();
			if (isAlertPresent_() == true) {
				Alert alert = driver.switchTo().alert();
				test.pass(alert.getText());
				System.out.println(alert.getText());
				alert.accept();
			} else {
				System.out.println("alert is not displaying");
				test.fail("Alert is not displaying");
			}
		}

		if (testcase.trim().equals("from date validation")) {
			Thread.sleep(5000);
			form_date.clear();
			form_date.sendKeys(alphabets);
			date_Alert(test, alphabets);
			Thread.sleep(5000);
			form_date.clear();
			form_date.sendKeys(special_chars);
			date_Alert(test, special_chars);
			form_date.clear();
			form_date.sendKeys(alpha_numerics);
			date_Alert(test, alpha_numerics);
			Thread.sleep(5000);
			form_date.clear();
			form_date.sendKeys(alpha_special_chars);
			date_Alert(test, alpha_special_chars);
			Thread.sleep(5000);
			form_date.clear();
			form_date.sendKeys(numbers_special_chars);
			date_Alert(test, numbers_special_chars);
			Thread.sleep(5000);
			form_date.clear();
			form_date.sendKeys(to_date_less_than_three_digits);
			date_Alert(test, to_date_less_than_three_digits);
			form_date.clear();
			form_date.sendKeys(to_date_greater_than_two_digits);
			action.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(1000);
			if (isAlertPresent_() == false) {
				System.out.println("system is taking some other date: " + form_date.getText());
				test.pass("Date entered is: " + to_date_greater_than_two_digits + ": System is taking some other date");
			}

		}
		if (testcase.trim().equals("to date validation")) {
			Thread.sleep(5000);
			to_date.clear();
			to_date.sendKeys(alphabets);
			date_Alert(test, alphabets);
			Thread.sleep(5000);
			to_date.clear();
			to_date.sendKeys(special_chars);
			date_Alert(test, special_chars);
			Thread.sleep(5000);
			to_date.clear();
			to_date.sendKeys(alpha_numerics);
			date_Alert(test, alpha_numerics);
			Thread.sleep(5000);
			to_date.clear();
			to_date.sendKeys(alpha_special_chars);
			date_Alert(test, alpha_special_chars);
			Thread.sleep(5000);
			to_date.clear();
			to_date.sendKeys(numbers_special_chars);
			date_Alert(test, numbers_special_chars);
			Thread.sleep(5000);
			to_date.clear();
			to_date.sendKeys(to_date_less_than_three_digits);
			date_Alert(test, to_date_less_than_three_digits);
			to_date.clear();
			Thread.sleep(5000);
			to_date.sendKeys(to_date_greater_than_two_digits);
			action.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(1000);
			if (isAlertPresent_() == false) {
				alert_message = "System is taking some other date";
				System.out.println("system is taking some other date");
				test.pass("Date entered is " + to_date_greater_than_two_digits + ": " + alert_message);
			}

		}

	}

	public void filter_in_search(String filter, WebElement arrow, List<WebElement> list) throws InterruptedException {
		arrow.click();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equals(filter.trim())) {
				list.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
	}

	public void two_filter_function(String customer, String department, String location1, String class1,
			WebElement customer_arrow, WebElement department_arrow, WebElement location_arrow, WebElement class_arrow,
			List<WebElement> customer_list, List<WebElement> department_list, List<WebElement> location_list,
			List<WebElement> class_list, String fromdate, String todate, String testcase, ExtentTest test)
			throws InterruptedException {
		List<String> invoice_number_in_bei = new ArrayList<String>();
		for (int i = 0; i < doc_nr.size(); i++) {
			invoice_number_in_bei.add(doc_nr.get(i).getText());
		}
		driver.navigate()
				.to("https://tstdrv939179-rp.app.netsuite.com/app/common/search/searchresults.nl?searchid=535&whence=");
		if (driver.findElement(By.xpath("//span[@aria-label='Expand/Collapse filters']")).getAttribute("aria-expanded")
				.equals("false")) {
			expand_collapse_in_search.click();
		}
		if (testcase.equals("invoices with customername and location")) {
			filter_in_search(customer, customer_arrow, customer_list);
			filter_in_search(location1, location_arrow, location_list);
		}
		if (testcase.equals("Invoices with customername and class")) {
			filter_in_search(customer, customer_arrow, customer_list);
			filter_in_search(class1, class_arrow, class_list);
		}
		if (testcase.equals("Invoices with customername and department")) {
			filter_in_search(customer, customer_arrow, customer_list);
			filter_in_search(department, department_arrow, department_list);
		}
		if (testcase.equals("invoices with multiple filters")) {
			filter_in_search(customer, customer_arrow, customer_list);
			filter_in_search(department, department_arrow, department_list);
			filter_in_search(location1, location_arrow, location_list);
			filter_in_search(class1, class_arrow, class_list);
		}
		Thread.sleep(2000);
		from_date_in_search.sendKeys(fromdate);
		to_date_in_search.click();
		Thread.sleep(3000);
		to_date_in_search.sendKeys(todate);
		from_date_in_search.click();
		Thread.sleep(3000);
		List<String> invoice_nr_in_search = new ArrayList<String>();
		for (int i = 0; i < doc_nr_in_search.size(); i++) {
			invoice_nr_in_search.add(doc_nr_in_search.get(i).getText().replace("Invoice #", ""));
		}
		Collections.sort(invoice_nr_in_search);
		Collections.sort(invoice_number_in_bei);
		System.out.println("invoice_nr_in_search " + invoice_nr_in_search);
		System.out.println("invoice_number_in_bei " + invoice_number_in_bei);
		if (invoice_nr_in_search.equals(invoice_number_in_bei)) {
			if (testcase.equals("invoices with customername and location")) {
				test.pass("Invoices are correctly displayed for given customer and location");
				System.out.println("Invoices are correctly displayed for given customer and location");

			}
			if (testcase.equals("Invoices with customername and class")) {
				test.pass("Invoices are correctly displayed for given customer and class");
				System.out.println("Invoices are correctly displayed for given customer and class");

			}
			if (testcase.equals("Invoices with customername and department")) {
				test.pass("Invoices are correctly displayed for given customer and department");
				System.out.println("Invoices are correctly displayed for given customer and department");
			}
			if (testcase.equals("invoices with multiple filters")) {
				test.pass("Invoices are correctly displayed for multiple filters");
				System.out.println("Multiple filters are working");
			}

		} else {
			test.fail(testcase + " is not working");
			System.out.println(testcase + " is not working");
		}

	}

	public void two_filters(String customer_name1, String department1, String class1, String location1,
			String from_date1, String to_date1, String testcase, ExtentTest test) throws Exception {
		required_role("BEI-AR", "Tvarana Dev Production");
		authpage = new AuthPageNavigation();
		authpage.navigatetoBEI();
		Actions action = new Actions(driver);
		if (testcase.trim().equals("from date greater than to date")) {
			form_date.clear();
			form_date.sendKeys(from_date1.trim());
			action.sendKeys(Keys.TAB).build().perform();
			if (isAlertPresent_() == true) {
				Alert alert = driver.switchTo().alert();
				confirm_message = "The error message is " + alert.getText();
				test.pass("The error message is " + alert.getText());
				System.out.println("The error message is " + alert.getText());
			} else {
				System.out.println("Alert is not displaying");
				test.fail("Alert message is not displaying");
			}
		} else {
			from_to_date(from_date1, to_date1);
			if (testcase.trim().equals("due date greater than from and to date")) {
				due_datee.clear();
				// due_datee.sendKeys(due_date);
				if (isAlertPresent() == true) {
					Alert alert = driver.switchTo().alert();
					test.pass("The error message is:" + alert.getText());
					System.out.println(alert.getText());
					alert.accept();
				} else {
					test.fail("Alert is not displaying");
					System.out.println("Alert is not displaying");
				}
			} else {
				if (testcase.trim().equals("invoices with customername and location")) {
					selectcustomer(customer_name1);
					location.sendKeys(location1);
					Thread.sleep(1000);
					search_button.click();
					two_filter_function(customer_name1, department1, location1, class1, customer_arrow_in_search,
							dept_in_search_arrow, location_arrow_in_search, class_arrow_in_search,
							customer_list_in_search, dept_list_in_search, location_list_in_search, class_list_in_search,
							from_date1, to_date1, testcase, test);
				}
				if (testcase.trim().equals("Invoices with customername and class")) {
					selectcustomer(customer_name1.trim());
					classs.sendKeys(class1.trim());
					Thread.sleep(1000);
					search_button.click();
					two_filter_function(customer_name1, department1, location1, class1, customer_arrow_in_search,
							dept_in_search_arrow, location_arrow_in_search, class_arrow_in_search,
							customer_list_in_search, dept_list_in_search, location_list_in_search, class_list_in_search,
							from_date1, to_date1, testcase, test);
				}
				if (testcase.trim().equals("invoices with multiple filters")) {
					selectcustomer(customer_name1);
					classs.sendKeys(class1.trim());
					location.sendKeys(location1);
					department.sendKeys(department1);
					Thread.sleep(1000);
					search_button.click();
					two_filter_function(customer_name1, department1, location1, class1, customer_arrow_in_search,
							dept_in_search_arrow, location_arrow_in_search, class_arrow_in_search,
							customer_list_in_search, dept_list_in_search, location_list_in_search, class_list_in_search,
							from_date1, to_date1, testcase, test);
				}
				if (testcase.trim().equals("Invoices with customername and department")) {
					selectcustomer(customer_name1);
					department.sendKeys(department1);
					Thread.sleep(1000);
					search_button.click();
					two_filter_function(customer_name1, department1, location1, class1, customer_arrow_in_search,
							dept_in_search_arrow, location_arrow_in_search, class_arrow_in_search,
							customer_list_in_search, dept_list_in_search, location_list_in_search, class_list_in_search,
							from_date1, to_date1, testcase, test);

				}
				if (testcase.trim().equals("Verifying number of selected records functionality")) {
					search_button.click();
					Thread.sleep(5000);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,500)", "");
					Thread.sleep(3000);
					unmark_all.click();
					Thread.sleep(5000);
					if (no_of_selected_invoices_checkbox.getText().trim().equals("0")) {
						test.pass("Number of selected records after clicking on unmark all button is: "
								+ no_of_selected_invoices_checkbox.getText());
					} else {
						test.fail("Number of selected records functionality is not working");
					}
					for (int i = 0; i < 5; i++) {
						select_invoices.get(i).click();
					}
					Thread.sleep(5000);
					if (no_of_selected_invoices_checkbox.getText().trim().equals("5")) {
						test.pass("Number of selected records after selecting 5 invoices : "
								+ no_of_selected_invoices_checkbox.getText());
					} else {
						test.fail("Number of selected records functionality is not working");
					}

				}
				if (testcase.trim().equals("unmark all functionality testing")) {
					from_to_date(from_date1, to_date1);
					search_button.click();
					int unmark_all_count = 0;
					unmark_all.click();
					Thread.sleep(5000);
					for (int i = 0; i < select_checkbox_checking.size(); i++) {
						WebElement select_index = select_checkbox_checking.get(i);
						if (select_index.getAttribute("class").contains("checkbox_unck")) {
							unmark_all_count = unmark_all_count + 1;
						}

					}

					Thread.sleep(2000);

					System.out.println("unmark all count is " + unmark_all_count);
					System.out.println("size of checkboxes " + select_checkbox_checking.size());
					if (unmark_all_count == select_checkbox_checking.size()) {
						confirm_message = "Unmark all functionality is working";
						System.out.println("unmark all is working");
						test.pass(confirm_message);
					} else {
						confirm_not = "Unmark all functionality is not working";
						test.fail(confirm_not);
					}

				}
				if (testcase.trim().equals("mark all functionality testing")) {
					from_to_date(from_date1, to_date1);
					search_button.click();
					int mark_all_count = 0;
					mark_all.click();
					for (int i = 0; i < select_checkbox_checking.size(); i++) {
						WebElement select_index = select_checkbox_checking.get(i);
						if (select_index.getAttribute("class").contains("checkbox_ck")) {
							mark_all_count = mark_all_count + 1;
						}
					}
					System.out.println("mark all count is " + mark_all_count);
					System.out.println("size of checkboxes " + select_checkbox_checking.size());
					if (mark_all_count == select_checkbox_checking.size()) {
						confirm_message = "Mark all functionality is working";
						System.out.println("mark all is working");
						test.pass(confirm_message);
					} else {
						confirm_not = "Mark all functionality is not working";
						System.out.println(confirm_not);
						test.fail(confirm_not);
					}

				}
			}
		}

	}

	public void required_role(String name, String company) throws InterruptedException {
		String company_name = driver.findElement(By.xpath("//span[@class='ns-role-company']")).getText();
		String role = driver.findElement(By.xpath("//span[@class='ns-role-name']")).getText();
		if (role.trim().equals(name.trim()) && company_name.trim().equals(company.trim())) {
			System.out.println("alrdy in that role");
		} else {
			view_roles.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@aria-label='" + name + "']")).click();
			Thread.sleep(5000);
		}
	}

	public void consolidate_invoices(ExtentTest test) throws InterruptedException {
		String invoices = null;
		String customer = null;
		int invoices_count = 0;
		String invoice_number_final = null;
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 30);
		required_role("Administrator", "Tvarana Dev Production");
		// if(role.getText().equals(anObject))
		Thread.sleep(5000);
		navigate_to_consolidate_customer_invoice();
		due_date_in_consolidation.click();
		due_date_in_consolidation.clear();
		due_date_in_consolidation.sendKeys("3/17/2021");
		driver.findElement(By.xpath("//input[@id='custpage_search']")).click();
		Thread.sleep(3000);
		for (int i = 0; i < consolidate_invoice_checkbox.size(); i++) {
			if (i == 1)
				break;
			consolidate_invoice_checkbox.get(i).click();
			WebElement no_of_invoices = consolidate_no_invoices.get(i);
			invoices = no_of_invoices.getText();
			invoices_count = Integer.parseInt(invoices);
			WebElement customer_name = consolidate_customer.get(i);
			customer = customer_name.getText();
			Thread.sleep(5000);
			submit_consolidate.click();
			wait.until(ExpectedConditions.visibilityOf(consolidate_link));
			consolidate_link.click();
		}
		System.out.println("customer is " + customer);
		System.out.println("invoice count is " + invoices_count);
		// test.pass("Invoice count is: "+invoices_count);
		String invoice_split[] = new String[invoices_count];
		Thread.sleep(3000);
		consolidate_arrow.click();
		for (int j = 0; j < consolidate_dropdown.size(); j++) {
			WebElement recently = consolidate_dropdown.get(j);
			if (recently.getText().trim().equals("Recently Created")) {
				recently.click();
				break;
			}
		}
		Thread.sleep(5000);
		driver.navigate().refresh();
		for (int i = 0; i < consolidate_invoice_after.size(); i++) {
			if (i == 1)
				break;
			WebElement customer_af = consolidate_customer_after.get(i);
			WebElement invoice_af = consolidate_invoice_after.get(i);
			if (i == 0) {
				if (invoices_count == 1) {
					invoice_number_final = invoice_af.getText().replace("CustInvc-", "").trim();
					System.out.println("one invoice final is " + invoice_number_final);
					test.pass("Invoice selected in the consolidate screen is : " + invoice_number_final);
					break;
				}
				if (invoices_count > 1) {
					invoice_number_final = invoice_af.getText().replace("CustInvc-", "").trim();
					for (int j = 0; j < invoice_split.length; j++) {
						invoice_split = invoice_number_final.split(",");
					}
					for (int j = 0; j < invoice_split.length; j++) {
						System.out.println("Multiple final invoices are " + invoice_split[j]);
						test.pass("invoices selected in the consolidate screen are " + invoice_split[j]);
					}

				}

			}

		}
		required_role("BEI-AR", "Tvarana Dev Production");
		Thread.sleep(5000);
		authPage = new AuthPageNavigation();
		authPage.navigatetoBEI();
		// customer_name.sendKeys(customer);
		form_date.clear();
		form_date.sendKeys("3/1/2021");
		to_date.clear();
		to_date.sendKeys("3/20/2021");
		due_datee.sendKeys("3/17/2021");
		search_button.click();
		int count4 = 0;
		if (invoices_count == 1) {
			for (int i = 0; i < doc_nr.size(); i++) {
				WebElement invoicess = doc_nr.get(i);
				if (!invoice_number_final.equals(invoicess.getText())) {
					count4 = count4 + 1;
				}
			}
			if (count4 == doc_nr.size()) {
				System.out.println("consolidated invoices are not displaying in bei screen");
				test.pass("Consolidated invoice is not displaying in bei screen");

			}
		}
		int count3 = 0;
		int final_count = 0;
		boolean invoice_present = false;
		if (invoices_count > 1) {
			for (int i = 0; i < invoice_split.length; i++) {
				for (int j = 0; j < doc_nr.size(); j++) {
					WebElement invoicess = doc_nr.get(j);
					if (invoice_split[i].equals(invoicess.getText())) {
						invoice_present = true;
					}
				}

			}
			if (invoice_present == false) {
				System.out.println("consolidated invoices are not displaying in bei screen");
				test.pass("Consolidated invoices are not displaying in bei screen");
			}

		}

	}

	public void config_page() throws InterruptedException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(setup));
		action.moveToElement(setup).build().perform();
		Thread.sleep(2000);
		if (arrow.isDisplayed())
			action.moveToElement(arrow).build().perform();
		Thread.sleep(4000);
		action.moveToElement(bulk_email_invoice).build().perform();
		Thread.sleep(2000);
		action.moveToElement(configuration_page).build().perform();
		configuration_page.click();
	}

	public String editing_due_date(String dt, String customer, String url, String name, WebElement textarea,
			WebElement popup, int row) throws InterruptedException {
		System.out.println("going");
		String partial_url = null;
		Thread.sleep(5000);
		editing_search(customer, url, name, textarea, popup, row);
		// driver.navigate().to("https://tstdrv939179-rp.app.netsuite.com/app/common/search/searchresults.nl?searchid=539&whence=");
		for (int i = 0; i < partially_paid_invoices.size(); i++) {
			WebElement open_invoices = partially_paid_invoices.get(i);
			open_invoices.click();
			System.out.println("url storing");
			System.out.println(partial_url + " in search");
			break;
		}
		partial_url = driver.getCurrentUrl();
		edit_invoice.click();
		due_date_in_invoice_record.clear();
		due_date_in_invoice_record.sendKeys(dt);
		Thread.sleep(5000);
		save_invoice.click();
		try {
			String new_nr = driver.findElement(By.xpath("//h1[@class='uir-record-type']")).getText().trim();
			if (new_nr.equals("Duplicate Number")) {
				driver.findElement(By.xpath("//td[@id='tdbody_submitter']")).click();
			}
		} catch (Exception e) {
			System.out.println("no duplicate");
		}

		return partial_url;
	}

	public String script_exceution(String testcase, String partial_url, ExtentTest test) throws Exception {
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		Actions action = new Actions(driver);
		driver.navigate().to("https://tstdrv939179-rp.app.netsuite.com/app/common/scripting/scriptrecord.nl?id=1355");
		script_edit.click();
		action.moveToElement(edit_expand).build().perform();
		save_and_execute.click();
		if (isAlertPresent_() == true) {
			Alert alert1 = driver.switchTo().alert();
			alert1.accept();
		}
		Thread.sleep(5000);
		for (int i = 0; i < 50; i++) {
			driver.navigate().refresh();
			if (script_status.get(0).getText().equals("Complete"))
				break;
		}
		Thread.sleep(5000);
		driver.navigate().to(partial_url);
		Thread.sleep(2000);
		if (testcase.equals("sending auto email after due date")
				|| testcase.equals("sending auto email before due date")) {
			ExtentTest test1 = test.createNode("Verifying invoice and Customer Statement");
			String customer_name = customer_in_invoice.getText().trim();
			String invoice = invoice_nr_in_invoice.getText().trim();
			customer_in_invoice.sendKeys(selectLinkOpeninNewTab);
			windowHandle();
			Thread.sleep(1000);
			communication_tab.click();
			String customer_invoice = attachments_in_customer_record.get(0).getText().trim().replaceAll(".pdf", "")
					.replaceAll("Invoice_", "");
			if (customer_invoice.contains(customer_name.trim())) {
				test1.pass("Customer Statement is attached for correct customer");
				System.out.println("Customer Statement is attached for correct customer");
			} else {
				test1.fail("Customer Statement is not attached for correct customer");
				System.out.println("Customer Statement is not attached for correct customer");
			}
			if (customer_invoice.contains(invoice)) {
				test1.pass("Correct invoice is sent to the customer");
				System.out.println("Correct invoice is sent to the customer");
			} else {
				test1.fail("Correct invoice is not sent to the customer");
				System.out.println("Correct invoice is not sent to the customer");

			}
			driver.close();
			Thread.sleep(1000);
			driver.switchTo().window(parentWindow);
		}
		driver.findElement(By.xpath("//td[@id='custom44lnk']")).click();
		String auto_email_senddate = driver
				.findElement(
						By.xpath("//span[@id='custbody_tss_bei_sent_date_fs_lbl_uir_label']//following-sibling::span"))
				.getText().trim();
		return auto_email_senddate;
	}

	public void navigate_to_config(String days_before_due_date, String days_after_due_date, String testcase,
			String customer, ExtentTest test) throws Exception {
		String auto_email_senddate = null;
		String[] bulk_email_date = new String[2];
		int before_date = Integer.parseInt(days_before_due_date);
		int after_date = Integer.parseInt(days_after_due_date);
		SimpleDateFormat df = new SimpleDateFormat("M/d/yyyy");
		String formatted = df.format(new Date());
		System.out.println("Todays date is " + formatted);
		String dt = "2008-1-1"; // Start date
		SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(formatted));
		if (testcase.trim().equals("sending auto email before due date")
				|| (testcase.trim().equals("sending email to partially paid invoices")) || testcase.trim().equals(
						"Verifying multi attach functionlity for same customer different invoices before due date with same due date")) {
			c.add(Calendar.DATE, before_date); // number of days to add
			dt = sdf.format(c.getTime());
			System.out.println("tomorrow's date is " + dt);
		}
		String dt1 = "2008-1-1"; // Start date
		c.setTime(sdf.parse(formatted));
		if (testcase.trim().equals("sending auto email after due date")) {
			c.add(Calendar.DATE, -(after_date)); // number of days to add
			dt1 = sdf.format(c.getTime());
			System.out.println("Yesterday's date is :" + dt1);
		}
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions action = new Actions(driver);
		// required_account("Administrator", "Tvarana Dev Test", "PRODUCTION");
		Thread.sleep(5000);
		if (testcase.trim().equals("sending email to partially paid invoices")) {

			config_page();
			before_email_arrow.click();
			dropdown_email_after_before.get(0).click();
			submit_config.click();
			Alert alert = driver.switchTo().alert();
			System.out.println("The error is " + alert.getText());
			ExtentTest test1 = test
					.createNode("sending emails to customer after the due date without selecting email template");
			test1.pass("The error is " + alert.getText());
			alert.accept();
			after_email_arrow.click();
			dropdown_email_after_before.get(0).click();
			submit_config.click();
			driver.switchTo().alert();
			System.out.println("The error message is " + alert.getText());
			ExtentTest test2 = test
					.createNode("sending emails to customer before the due date without selecting email template");
			test2.pass("The error is " + alert.getText());
			alert.accept();
			no_of_days_after_due_date.clear();
			no_of_days_after_due_date.sendKeys("1");
			before_email_arrow.click();
			for (WebElement template : dropdown_email_after_before) {
				if (template.getText().trim().equals("Invoice Email Template")) {
					template.click();
					break;
				}
			}
			Thread.sleep(7000);
			if (after_email_arrow.isDisplayed())
				after_email_arrow.click();
			for (WebElement template : dropdown_email_after_before) {
				if (template.getText().trim().equals("CI Dunning - Level 1")) {
					template.click();
					break;
				}
			}

			submit_config.click();
			driver.navigate().back();
		}
		String invoice_url = null;
		String partial_url = null;

		if (testcase.trim().equals("sending email to partially paid invoices")) {
			partial_url = editing_due_date(dt, customer,
					"https://tstdrv939179-rp.app.netsuite.com/app/common/search/searchresults.nl?scrollid=539&searchid=539&refresh=&whence=",
					"Name", search_text_area, name_popup_list, 2);
			@SuppressWarnings("deprecation")
			WebDriverWait wait4 = new WebDriverWait(driver, 50);
			wait4.until(ExpectedConditions.visibilityOf(amount_due));
			String amountTopay = amount_due.getText().replace(",", "");
			System.out.println("amount is " + amountTopay);
			double j = Double.parseDouble(amountTopay);
			Thread.sleep(3000);
			String ref_no_inv = reference_no_in_invoice.getText().trim();
			System.out.println("reference no in invoice " + ref_no_inv);
			wait4.until(ExpectedConditions.visibilityOf(accept_payment));
			accept_payment.click();
			for (int i = 0; i < ref_no_in_payment.size(); i++) {
				WebElement ref = ref_no_in_payment.get(i);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", ref);
				if (ref.getText().trim().equals(ref_no_inv)) {
					if (j > 101.00) {
						j = j - 100.00;
						payment_amount_click.get(i).click();
						Thread.sleep(3000);
						payment_amount.get(i).clear();
						Thread.sleep(2000);
						payment_amount.get(i).sendKeys(Double.toString(j));
						Thread.sleep(2000);
						wait.until(ExpectedConditions.visibilityOf(payment_save));
						break;

					}
					if (j <= 100 && j > 10) {
						j = j - 10.00;
						payment_amount_click.get(i).click();
						Thread.sleep(3000);
						payment_amount.get(i).clear();
						Thread.sleep(2000);
						payment_amount.get(i).sendKeys(Double.toString(j));
						Thread.sleep(2000);
						wait.until(ExpectedConditions.visibilityOf(payment_save));
						break;

					}
					if (j <= 10 && j > 2) {
						j = j - 1;
						payment_amount_click.get(i).click();
						Thread.sleep(3000);
						payment_amount.get(i).clear();
						Thread.sleep(2000);
						payment_amount.get(i).sendKeys(Double.toString(j));
						Thread.sleep(2000);
						wait.until(ExpectedConditions.visibilityOf(payment_save));
						break;

					}

				}

			}
			payment_save.click();
			Thread.sleep(5000);
			auto_email_senddate = script_exceution(testcase, partial_url, test);
			if (auto_email_senddate.trim().equals("")) {
				confirm_message = "Auto Email is not sent to partially paid invoices";
				System.out.println("Auto Email is not sent to partially paid invoices");
				test.pass(confirm_message);
			} else {
				confirm_not = "Auto Email is sent to partially paid invoices so test case is failed";
				test.fail(confirm_message);
			}

		}
		if (testcase.equals("sending auto email before due date")) {
			Thread.sleep(5000);
			partial_url = editing_due_date(dt, customer,
					"https://tstdrv939179-rp.app.netsuite.com/app/common/search/searchresults.nl?scrollid=539&searchid=539&refresh=&whence=",
					"Name", search_text_area, name_popup_list, 2);

			System.out.println("parrtial url is:" + partial_url);
			auto_email_senddate = script_exceution(testcase, partial_url, test);
			if (auto_email_senddate.equals(formatted)) {
				confirm_message = "The auto email is sent successfully ";
				System.out.println("The auto email is sent successfully");
				test.pass(confirm_message);
			}
			if (auto_email_senddate.trim().equals("")) {
				confirm_not = "Auto email is not  sending";
				System.out.println("Auto email is not sending");
				test.fail(confirm_not);

			}
			customer_statement_verifying(formatted, test);
		}
		if (testcase.trim().equals("sending auto email after due date")) {

			partial_url = editing_due_date(dt1, customer,
					"https://tstdrv939179-rp.app.netsuite.com/app/common/search/searchresults.nl?scrollid=539&searchid=539&refresh=&whence=",
					"Name", search_text_area, name_popup_list, 2);

			auto_email_senddate = script_exceution(testcase, partial_url, test);
			if (auto_email_senddate.equals(formatted)) {
				confirm_message = "The auto email is sent successfully ";
				System.out.println("The auto email is sent successfully");
				test.pass(confirm_message);
			}
			if (auto_email_senddate.trim().equals("")) {
				confirm_not = "Auto email is not  sending";
				System.out.println("Auto email is not sending");
				test.fail(confirm_not);

			}
			customer_statement_verifying(formatted, test);

		}

	}

	public void customer_statement_verifying(String formatted, ExtentTest test) {
		ExtentTest test1 = test.createNode("Verifying Customer Statement");
		String[] bulk_email_date = new String[2];
		for (int i = 0; i < bulk_email_send_date.size(); i++) {
			WebElement bulk_index = bulk_email_send_date.get(i);
			String bulk_text = bulk_index.getText();
			bulk_email_date = bulk_text.split(" ");
			System.out.println("The date array is " + bulk_email_date[i]);
			if (bulk_email_date[0].equals(formatted)) {
				WebElement customer_index = customer_statement.get(i);
				if (customer_index.getText().equals("Yes")) {
					System.out.println("customer statement is included");
					test1.pass("customer statement is included");
					break;
				} else {
					System.out.println("customer statement is not included");
					test1.fail("cutomer statement is not included");
				}
			}
		}
	}

	public void dashboard(String from_date1, String to_date1, String testcase, ExtentTest test) throws Exception {
		required_role("BEI-AR", "Tvarana Dev Production");
		authpage = new AuthPageNavigation();
		authpage.navigatetoBEI();
		if (testcase.trim().equals("invoices followed up through bei")) {
			String total_invoices = null;
			dashboard.click();
			try {
				over_total.click();
				Thread.sleep(3000);
				total_invoices = total_invoices_followed_up.getText();

			} catch (Exception e) {
				total_invoices = total_invoices_followed_up.getText();
			}
			if (!total_invoices.equals("")) {
				confirm_message = "Total invoices followed up through bei is " + total_invoices;
				System.out.println("Total invoices followed up through bei is " + total_invoices);
				test.pass(confirm_message);
			} else {
				confirm_not = "Total invoices followed up through bei is not displayed";
				test.fail(confirm_not);
				System.out.println(confirm_not);
			}

		} else if (testcase.trim().equals("no of open days of invoice")) {
			dashboard.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", bei_comparsion);
			String customer_name = Customer_open_days_in_bei.get(0).getText().trim();
			String open_days = customer_open_days.get(0).getText();
			Thread.sleep(2000);
			editing_search(customer_name,
					"https://tstdrv939179-rp.app.netsuite.com/app/common/search/searchresults.nl?scrollid=552&searchid=552&refresh=&whence=",
					"Name", search_text_area, name_popup_list, 2);
			Thread.sleep(1000);
			String final_max_days = driver
					.findElement(By.xpath("//table[@id='div__bodytab']//tr[contains(@id,'row')]//td")).getText().trim();
			if (open_days.equals(final_max_days)) {
				confirm_message = "Open days are correct";
				System.out.println("The open days are correct");
				test.pass("Open days are displayed correct: " + final_max_days);
			} else {
				confirm_not = "Open days are not correct";
				test.fail("Open days are not correct: " + final_max_days);

			}

		} else {
			String customer_name = null;
			String customer_url = null;
			String invoice_url = null;
			String doc_texttt = null;
			int count = 0, count_empty = 0;
			// from_to_date(from_date1, to_date1);
			Actions action = new Actions(driver);
			action.keyDown(Keys.CONTROL).click(dashboard).keyUp(Keys.CONTROL).build().perform();
			windowHandle();
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("window.scrollBy(0,300)", "");
			// total_count_bei.click();
			String bei_url = null;
			String customer_name_bei = bei_comparison_customers.get(0).getText().trim();
			String no_of_emails = no_of_emails_sent_through_bei.get(0).getText().trim();
			editing_search(customer_name_bei,
					"https://tstdrv939179-rp.app.netsuite.com/app/common/search/searchresults.nl?searchid=554&whence=",
					"Customer", customer_textarea, customer_pop_up_link, 1);
			Thread.sleep(1000);
			String final_email_count = driver
					.findElement(By.xpath("//table[@id='div__bodytab']//tr[contains(@id,'row')]//td")).getText().trim();
			if (no_of_emails.equals(final_email_count)) {
				test.pass("Number of Emails Sent through bei are displayed correctly");
			} else {
				test.fail("Number of Emails sent through bei are not correct");
			}

		}
//		for(int i=0;i<bei_comparison_customers.size();i++)
//		{
//			WebElement bei_customer_index=bei_comparison_customers.get(i);
//			String customer=bei_customer_index.getText();
//			if(customer_name.equals(customer))
//			{
//				WebElement no_of_invoices=no_of_emails_sent_through_bei.get(i);
//				no_of_invoices1=no_of_invoices.getText().replace(",","");
//			invoices_before=Integer.parseInt(no_of_invoices1);
//			System.out.println("no_of_invcoies before sending email "+invoices_before);
//			test.pass("no_of_invcoies before sending email "+invoices_before);
//			bei_url=driver.getCurrentUrl();
//			System.out.println("url is :"+bei_url);
//			break;
//			}
//		}
//		Thread.sleep(5000);
//		driver.switchTo().window(parentWindow);
//		System.out.println("count is "+count);
//		System.out.println("count_empty is "+count_empty);
//		Thread.sleep(2000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0,0)", "");
//		Thread.sleep(7000);
//		WebElement other_menu=driver.findElement((By.xpath("//li[@id='ns-header-menu-main-item1']")));
//		action.moveToElement(other_menu).build().perform();
//		action.moveToElement(process_button).build().perform();
//		process_button.click();
//		Thread.sleep(5000);
//		@SuppressWarnings("deprecation")
//		WebDriverWait wait = new WebDriverWait(driver, 60);
//		//wait.until(ExpectedConditions.visibilityOfAllElements(hold_on_message));
//		System.out.println(hold_on_message.getText().trim());
//		if (hold_on_message.getText().trim().equals("Please wait until the process completes...")) {
//			System.out.println("processing message is displayed correctly");
//			ExtentTest test1=test.createNode("Processing Message Testing");
//			test1.pass("processing message is displayed correctly");
//		}
//		refresh_until_process();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//input[@name='custpage_resendemail_send']//following-sibling::img")));
//
//		show_emailed_invoices.click();
//		search_button.click();
//		for(int i=0;i<doc_nr.size();i++)
//		{
//			WebElement doc_index=doc_nr.get(i);
//			if(doc_index.getText().equals(doc_texttt))
//			{
//				System.out.println("show only emailed invoices checkbox is verified");
//				test.pass("show only emailed invoices checkbox is verified");
//				break;
//			}
//		} 
//		driver.navigate().to(bei_url);
//		for(int i=0;i<bei_comparison_customers.size();i++)
//		{
//			WebElement bei_customer_index=bei_comparison_customers.get(i);
//			String customer=bei_customer_index.getText();
//			if(customer_name.equals(customer))
//			{
//				WebElement no_of_invoices=no_of_emails_sent_through_bei.get(i);
//				String no_of_invoices_after=no_of_invoices.getText().replace(",","");
//				int invoices=Integer.parseInt(no_of_invoices_after);
//				System.out.println("no of invoices after sending email "+invoices);
//				test.pass("no of invoices after sending email "+invoices);
//				if(invoices>invoices_before)
//				{
//					System.out.println("no of invoices sent is verified");
//					test.pass("no of invoices sent is verified");
//					break;
//				}
//			}
//		}
//	}
	}

	public String customer_email_ids() {
		String parent_email = null;
		String main_email = email_fiels_in_customer.getText().trim();
		communication_tab.click();
		String bulk_emails_from_communication_tab = bulk_email_addresses.getText().trim();
		if (!main_email.equals("") && !bulk_emails_from_communication_tab.equals("")) {
			parent_email = main_email + "," + bulk_emails_from_communication_tab;
		} else if (main_email.equals("")) {
			parent_email = bulk_emails_from_communication_tab;
		} else {
			parent_email = main_email;
		}
		return parent_email;

	}

	public String invoice_emai_ids() {
		String invoice_emails = null;
		communication_tab_in_invoice.click();
		invoice_emails = to_be_emailed.getText().trim();
		return invoice_emails.replaceAll("\\s{1,}", "");
	}

	public String credit_memo_email_ids() {
		String credit_emails = null;
		communication_tab_in_credit_memo.click();
		credit_emails = email_ids_in_credit_memo.getText().trim();
		return credit_emails.replaceAll("\\s{1,}", "");

	}

	public void email_sourcing(String from_date1, String to_date1, String testcase, String customername,
			ExtentTest test) throws Exception {
		authpage = new AuthPageNavigation();
		if(testcase.trim().equals("Verification of processing of 500 invoices"))
		{
			test.info("Not feasible for Automation");
		}
		else
		{
		authpage.navigatetoBEI();
		if (testcase.trim().equals("Verification of show only emailed invoices checkbox functionality")) {
			form_date.clear();
			if (driver.findElement(By.xpath("//span[@id='custpage_paidinfull_fs']")).getAttribute("class")
					.contains("checkbox_ck")) {
				show_only_open_invoices.click();
			}
			if (driver.findElement(By.xpath("//span[@id='custpage_resendemail_fs']")).getAttribute("class")
					.contains("checkbox_unck")) {
				show_emailed_invoices.click();
			}
			search_button.click();
			String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			doc_nr.get(0).sendKeys(selectLinkOpeninNewTab);
			windowHandle();
			bulk_email_invoices_tab.click();
			if (email_status_in_invoice.getText().equals("COMPLETED")) {
				System.out.println(
						"Emailed invoices are displayed correctly by selecting show emailed invoices checkbox");
				test.pass("Emailed invoices are displayed correctly by selecting show emailed invoices checkbox");
			} else {
				System.out.println(
						"Emailed invoices are not displayed correctly by selecting show emailed invoices checkbox");
				test.fail("Emailed invoices are not displayed correctly by selecting show emailed invoices checkbox");
			}
		}
		else if(testcase.trim().equals("Verification of Exclude Customer from Bulk Email Invoice functionality"))
		{
			from_to_date(from_date1, to_date1);
			selectcustomer(customername.trim());
			Actions actions=new Actions(driver);
			actions.moveToElement(customer_move_arrow_in_invoice).build().perform();
			Thread.sleep(1000);
			actions.moveToElement(customer_open_arrow).click().build().perform();
			Thread.sleep(1000);
			windowHandle();
			bulk_email_tab_in_customer.click();
			Thread.sleep(1000);
			boolean exclude=false;
			if(exclude_checkbox_in_customer.getAttribute("class").equals("checkbox_read_ck"))
			{
				//test.pass("Exclude from bulk email checkbox is checked in customer record");
				System.out.println("customer is excluded");
				exclude=true;
			}
			driver.close();
			driver.switchTo().window(parentWindow);
			Thread.sleep(2000);
			search_button.click();
			Thread.sleep(2000);
			if(doc_nr.size()>0 && exclude==true)
			{
				test.fail("Invoices of the excluded customer are getting displayed in the BEI Screen");
			}
			else
			{
				test.pass("Invoices of the excluded customer are not getting displayed in the BEI screen");
			}
			
		}
		
		else
		{
		String email_ids_in_bei = null;
		String parent_email = null;
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		from_to_date(from_date1, to_date1);
		if (testcase.trim().equals("parent customer email id's")) {
			customer_arrow.click();
			pop_up_list.click();
			input_customer.sendKeys(customername);
			search_customer.click();
			Thread.sleep(2000);
			for (int i = 0; i < customer_list.size(); i++) {
				System.out.println(customer_list.get(i).getText());
				if (customer_list.get(i).getText().trim().equals(customername.trim())) {
					customer_list.get(i + 1).click();
					Thread.sleep(5000);
					break;
				}
			}
			show_parent_emails.click();
			Thread.sleep(2000);
			search_button.click();
			js.executeScript("arguments[0].scrollIntoView(true);", email_to.get(0));
			Thread.sleep(1000);
			email_ids_in_bei = email_to.get(0).getText().trim();
			customer_link.get(0).sendKeys(selectLinkOpeninNewTab);
			Thread.sleep(1000);
			windowHandle();
			Thread.sleep(2000);
			parent_company_value.sendKeys(selectLinkOpeninNewTab);
			windowHandle();
			Thread.sleep(1000);
			parent_email = customer_email_ids();
			driver.close();
			Thread.sleep(1000);
			driver.switchTo().window(parentWindow);
			System.out.println("parent email id's: " + parent_email);
			System.out.println("bulk email id's: " + email_ids_in_bei);
			if (parent_email.equals(email_ids_in_bei.trim())) {
				test.pass("Email id's in parent customer: " + parent_email + "</br>" + " Email id's in bei screen: "
						+ email_ids_in_bei);
				System.out.println("show parent customers checkbox is working");
				test.pass("Parents email id's are sourcing correctly");
			} else {
				test.fail("Email id's in parent customer: " + parent_email + "</br>" + " Email id's in bei screen: "
						+ email_ids_in_bei);
				System.out.println("show parent customers checkbox is  not working");
				test.fail("Parents email id's are not sourcing correctly");

			}

		}
		if (testcase.trim().equals("sourcing of emails from customer record to credit memo")) {
			String email_from_customer = null;
			String email_from_credit_memo = null;
			selectcustomer(customername);
			credit_memos.click();
			search_button.click();
			for (int i = 0; i < tran_type.size(); i++) {
				if (tran_type.get(i).getText().equals("Credit Memo")) {
					email_ids_in_bei = email_to.get(i).getText();
					customer_link.get(i).sendKeys(selectLinkOpeninNewTab);
					windowHandle();
					Thread.sleep(1000);
					email_from_customer = customer_email_ids();
					driver.close();
					Thread.sleep(1000);
					driver.switchTo().window(parentWindow);
					Thread.sleep(1000);
					doc_nr.get(i).sendKeys(selectLinkOpeninNewTab);
					windowHandle();
					Thread.sleep(1000);
					email_from_credit_memo = credit_memo_email_ids();
					driver.close();
					Thread.sleep(1000);
					driver.switchTo().window(parentWindow);
					break;

				}
			}
			System.out.println("email from customer: " + email_from_customer);
			System.out.println("email from bei: " + email_ids_in_bei);
			System.out.println("email from credit memo: " + email_from_credit_memo);
			if (email_from_customer.equals(email_from_credit_memo)) {
				test.pass("Email id's from customer record: " + email_from_customer + "</br>"
						+ " Email id's from credit memo: " + email_from_credit_memo);
				test.pass("Email id's are sourced correctly from customer record to credit memo");
				System.out.println("Email id's are sourced correctly from customer record to credit memo");
			} else {
				test.fail("Email id's from customer record: " + email_from_customer + "</br>"
						+ " Email id's from credit memo: " + email_from_credit_memo);
				test.fail("Email id's are not sourced correctly from customer record to credit memo");
				System.out.println("Email id's are not sourced correctly from customer record to credit memo");
			}
			if (email_ids_in_bei.equals(email_from_customer)) {
				test.pass("Email id's from customer record: " + email_from_customer + "</br>"
						+ " Email id's from bei screen: " + email_ids_in_bei);
				test.pass("Email id's are sourced correctly from customer record to bei screen");
				System.out.println("Email id's are sourced correctly from customer record to bei screen");
			} else {
				test.fail("Email id's from customer record: " + email_from_customer + "</br>"
						+ " Email id's from bei screen: " + email_ids_in_bei);
				test.fail("Email id's are not sourced correctly from customer record to bei screen ");
				System.out.println("Email id's are not sourced correctly from customer record to bei screen");
			}

		}
		if (testcase.trim().equals("sourcing of emails from customer record to invoice")) {
			String email_from_customer = null;
			String email_from_invoice = null;
			selectcustomer(customername);
			search_button.click();
			js.executeScript("arguments[0].scrollIntoView(true);", email_to.get(0));
			email_ids_in_bei = email_to.get(0).getText().trim();
			customer_link.get(0).sendKeys(selectLinkOpeninNewTab);
			Thread.sleep(1000);
			windowHandle();
			email_from_customer = customer_email_ids();
			driver.close();
			Thread.sleep(1000);
			driver.switchTo().window(parentWindow);
			doc_nr.get(0).sendKeys(selectLinkOpeninNewTab);
			windowHandle();
			Thread.sleep(1000);
			email_from_invoice = invoice_emai_ids();
			driver.close();
			Thread.sleep(1000);
			driver.switchTo().window(parentWindow);
			System.out.println("email from customer: " + email_from_customer);
			System.out.println("email from invoice: " + email_from_invoice);
			System.out.println("email from bei: " + email_ids_in_bei);
			if (email_from_customer.equals(email_from_invoice)) {
				test.pass("Email id's in customer record :" + email_from_customer + " <br/>"
						+ " Email id's from invoice: " + email_from_invoice);
				test.pass("Email id's are sourced correctly from customer record to invoice record");
				System.out.println("Email id's are sourced correctly from customer record to invoice record");
			} else {
				test.fail("Email id's in customer record :" + email_from_customer + " <br/>"
						+ " Email id's from invoice: " + email_from_invoice);
				test.fail("Email id's are not sourced correctly from customer to invoice record");
				System.out.println("Email id's are not sourced correctly from customer to invoice record");
			}
			if (email_from_customer.equals(email_ids_in_bei)) {
				test.pass("Email id's in customer record :" + email_from_customer + " <br/>"
						+ " Email id's in bei screen: " + email_ids_in_bei);
				test.pass("Email id's are sourced correctly from customer record to bei screen");
				System.out.println("Email id's are sourced correctly from customer record to bei screen");
			}

			else {
				test.fail("Email id's in customer record :" + email_from_customer + " <br/>"
						+ " Email id's in bei screen: " + email_ids_in_bei);
				test.pass("Email id's are not sourced correctly from customer record to bei screen");
				System.out.println("Email id's are not sourced correctly from customer record to bei screen");

			}

		}
	}
		}
	}

	public void refresh_until_process() throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath("//div[@class='descr']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ele));
		for (;;) {
			WebElement ref1 = driver.findElement(By.xpath("//input[@id='custpage_refresh']"));
			if (ref1.isDisplayed()) {
				System.out.println(ref1.isDisplayed());
				Thread.sleep(2000);
				ref1.click();
				Thread.sleep(5000);
			} else {
				break;
			}
		}
	}

	public void bei_test(String form_date2, String to_date2, String testcase, String email_ids, String email2,
			ExtentTest test) throws Exception {
		// TODO Auto-generated method stub
		required_role("BEI-AR", "Tvarana Dev Production");
		if (testcase.trim().equals(
				"Verification of email confirmation with information on the total processed invoices in multi attach case")) {
			test.pass("Not able to check");
		}
		authpage = new AuthPageNavigation();
		authpage.navigatetoBEI();
		if (testcase.trim().equals("show only open invoices checkbox")) {
			if (driver.findElement(By.xpath("//span[@id='custpage_paidinfull_fs']")).getAttribute("class")
					.contains("checkbox_ck")) {
				System.out.println("open invoices is checked");
			} else {
				show_only_open_invoices.click();
				System.out.println("checked");
			}
			from_to_date(form_date2, to_date2);
			search_button.click();
			int count = 0;
			for (int i = 0; i < open_status.size(); i++) {
				WebElement open_index = open_status.get(i);
				if (open_index.getText().equals("Open")) {
					count = count + 1;
				}
				if (count == open_status.size()) {
					System.out.println("Invoices are displayed with Status Open only");
					test.pass("Invoices are displayed with Status Open only");
				}
			}
		}
		if (testcase.trim().equals("show only open invoices with credit memos")) {
			int open_invoice_count = 0;
			int credit_memos_count = 0;
			if (driver.findElement(By.xpath("//span[@id='custpage_showcreditmemos_fs']")).getAttribute("class")
					.contains("checkbox_unck")) {
				credit_memos.click();
			}
			from_to_date(form_date2, to_date2);
			search_button.click();
			for (int i = 0; i < tran_type.size(); i++) {
				WebElement tran_index = tran_type.get(i);
				if (tran_index.getText().equals("Invoice")) {
					open_invoice_count = open_invoice_count + 1;
				}
				if (tran_index.getText().equals("Credit Memo")) {
					credit_memos_count = credit_memos_count + 1;
				}
			}
			if (open_invoice_count > 0 && credit_memos_count > 0) {
				if (open_invoice_count + credit_memos_count == tran_type.size()) {
					System.out.println(
							"Invoices and credit memos are dislayed correctly by selecting show only open invoices with credit memos checkbox");
					test.pass(
							"Invoices and credit memos are dislayed correctly by selecting show only open invoices with credit memos checkbox");
				}
			} else {
				System.out.println(
						"Invoices and credit memos are not displayed correctly by selecting show only open invoices with credit memos checkbox");
				test.fail(
						"Invoices and credit memos are not displayed correctly by selecting show only open invoices with credit memos checkbox");
			}

		}
		if (testcase.trim().equals("show excluded invoices")) {
			from_to_date(form_date2, to_date2);
			if (driver.findElement(By.xpath("//span[@id='custpage_paidinfull_fs']")).getAttribute("class")
					.contains("checkbox_ck")) {
				show_only_open_invoices.click();
			}
			Thread.sleep(3000);
			search_button.click();
			@SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, 5);
			js.executeScript("arguments[0].scrollIntoView(true);", no_of_selected_invoices_checkbox);
			Thread.sleep(2000);
			unmark_all.click();
			Thread.sleep(5000);
			select_invoices.get(0).click();
			WebElement excluded_invoice = doc_nr.get(0);
			String excluded_invoice_text = excluded_invoice.getText();
			System.out.println("Excluded invoice is " + excluded_invoice_text);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,0)", "");
			Thread.sleep(2000);
			exclue_selected_invoices_checkbox.click();
			process_button.click();
			Thread.sleep(3000);
			refresh_until_process();
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//input[@name='custpage_excludeemail_send']//following-sibling::img")));
			search_button.click();
			boolean exclude_invoice = false;
			for (int i = 0; i < doc_nr.size(); i++) {
				if (doc_nr.get(i).getText().trim().equals(excluded_invoice_text)) {
					exclude_invoice = true;
				}
			}
			if (exclude_invoice == false) {
				ExtentTest test1 = test.createNode("Verification of excluded invoice checkbox in bei screen");
				test1.pass("Excluded invoice is not displayed in bei screen");
			}

			Thread.sleep(2000);
			show_excluded_invoices.click();
			search_button.click();
			Thread.sleep(3000);
			unmark_all.click();
			System.out.println("The size of docs are " + doc_nr.size());
			int count2 = 0;
			for (int i = 0; i < doc_nr.size(); i++) {
				WebElement excluded_invoice1 = doc_nr.get(i);
				String excluded_invoice_text1 = excluded_invoice1.getText();
				if (excluded_invoice_text.equals(excluded_invoice_text1)) {
					System.out.println("Excluded invoice after checking show excluded invoices checkbox "
							+ excluded_invoice_text1);
					test.pass("Excluded invoice is " + excluded_invoice_text1);
					System.out.println(
							"Excluded invoice " + excluded_invoice_text1 + " is displaying in excluded invoice list");
					test.pass("Excluded invoice " + excluded_invoice_text1 + " is displaying in excluded invoice list");
					test.pass("Selected invoice " + excluded_invoice_text1 + " is excluded");
					break;
				} else {
					count2 = count2 + 1;
					if (count2 == doc_nr.size()) {

						System.out.println("Exclude invoice checkbox is not working");
						test.fail("Exclude invoice checkbox is not working");
					}
				}
			}

		}
		if (testcase.trim().equals("sending email with template")) {
			String customer_url = null;
			String invoice_url = null;
			String doc_texttt = null;
			int count = 0, count_empty = 0;
			int count_before = 0;
			int count_after = 0;
			from_to_date(form_date2, to_date2);
			search_button.click();
			email_template_input.sendKeys("Invoice Email Template");
			unmark_all.click();
			for (int i = 0; i < email_to.size(); i++) {
				if (count == 1)
					break;
				System.out.println(email_to.size());
				WebElement email_index = email_to.get(i);
				char c = email_index.getText().charAt(0);
				boolean empty_or_not = false;
				if (c == ' ') {
					empty_or_not = true;
				}
				if (empty_or_not) {
					count_empty = count_empty + 1;
				} else {
					count = count + 1;
					String selectLinkOpeninNewTab1 = Keys.chord(Keys.CONTROL, Keys.ENTER);
					customer_link.get(i).sendKeys(selectLinkOpeninNewTab1);
					windowHandle();
					customer_url = driver.getCurrentUrl();
					driver.close();
					driver.switchTo().window(parentWindow);
					String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
					doc_nr.get(i).sendKeys(selectLinkOpeninNewTab);
					windowHandle();
					invoice_url = driver.getCurrentUrl();
					driver.close();
					driver.switchTo().window(parentWindow);
					WebElement doc_text = doc_nr.get(i);
					doc_texttt = doc_text.getText();
					select_invoices.get(i).click();
				}

			}
			System.out.println("count is " + count);
			System.out.println("count_empty is " + count_empty);
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,0)", "");
			Thread.sleep(2000);
			process_button.click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			Thread.sleep(3000);
			refresh_until_process();
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//input[@name='custpage_resendemail_send']//following-sibling::img")));
			show_emailed_invoices.click();
			search_button.click();
			int count1 = 0;
			for (int i = 0; i < doc_nr.size(); i++) {
				WebElement doc_index = doc_nr.get(i);
				if (doc_index.getText().equals(doc_texttt)) {
					String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
					doc_nr.get(i).sendKeys(selectLinkOpeninNewTab);
					windowHandle();
					bulk_email_invoices_tab.click();
					if (email_status_in_invoice.getText().equals("COMPLETED")) {
						System.out.println(
								"Emailed invoices are displayed correctly by selecting show emailed invoices checkbox");
						ExtentTest test1 = test.createNode("Show only Emailed invoice checkbox functionality testing");
						test1.pass(
								"Emailed invoices are displayed correctly by selecting show emailed invoices checkbox");
					}
					System.out.println("Sending email with selecting template is working");
					ExtentTest test2 = test.createNode("Sending email with selecting template testing");
					test2.pass("Sending email with selecting template is working");
					break;
				} else {
					count1 = count1 + 1;
					if (count1 == doc_nr.size()) {
						System.out.println(confirm_not);
						test.fail("Emailed invoice is not displayed");
					}
				}
			}

		}
		if (testcase.trim().equals("Invalid Email Template")) {
			from_to_date(form_date2, to_date2);
			search_button.click();
			email_template_input.sendKeys("Checkout Errors 10/15/18 11:44:20 PM");
			process_button.click();
			if (isAlertPresent_() == true) {
				Alert alert = driver.switchTo().alert();
				confirm_message = alert.getText();
				alert.accept();
				System.out.println("Error message is " + confirm_message);
				test.pass("Error message is " + confirm_message);
			} else {
				confirm_not = "Alert message is not displaying when we select invalid email template";
				System.out.println(confirm_not);
				test.fail(confirm_not);
			}
		}
		if (testcase.trim().equals("multiple invoices to multiple email ids")
				|| testcase.trim().equals("one invoice to multiple email ids")) {

			from_to_date(form_date2, to_date2);
			search_button.click();
			Thread.sleep(3000);
			email_template_input.sendKeys("Invoice Email Template");
			if (testcase.trim().equals("one invoice to multiple email ids")) {
				include_customer_statement_checkbox.click();
			}
			Thread.sleep(2000);
			unmark_all.click();
			Thread.sleep(5000);
			// js.executeScript("arguments[0].scrollIntoView(true);",doc_nr.get(0));
			int count = 0;
			String first_customer_url = "";
			String second_customer_url = "";
			String selectLinkOpeninNewTab1 = Keys.chord(Keys.CONTROL, Keys.ENTER);
			String invoice_nr = null;
			String customer_is = null;
			for (int i = 0; i < doc_nr.size(); i++) {
				if (count == 2)
					break;

				if (count != 1) {
					invoice_nr = doc_nr.get(i).getText().trim();
					customer_is = customer_names.get(i).getText().trim();
					email_to.get(i).click();
					email_to.get(i).sendKeys(Keys.CONTROL + "a");
					email_to.get(i).sendKeys(Keys.DELETE);
					select_invoices.get(i).click();
					email_to.get(i).sendKeys(email_ids.trim());
					customer_link.get(i).sendKeys(selectLinkOpeninNewTab1);
					windowHandle();
					first_customer_url = driver.getCurrentUrl();
					driver.close();
					Thread.sleep(2000);
					driver.switchTo().window(parentWindow);
					Thread.sleep(4000);
					if (testcase.trim().equals("one invoice to multiple email ids"))
						break;
				}
				if (count == 1) {
					email_to.get(i).click();
					email_to.get(i).sendKeys(Keys.CONTROL + "a");
					email_to.get(i).sendKeys(Keys.DELETE);
					select_invoices.get(i).click();
					email_to.get(i).sendKeys(email2);
					customer_link.get(i).sendKeys(selectLinkOpeninNewTab1);
					windowHandle();
					second_customer_url = driver.getCurrentUrl();
					driver.close();
					Thread.sleep(2000);
					driver.switchTo().window(parentWindow);
				}

				count = count + 1;

			}
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-800)", "");
			Thread.sleep(5000);
			process_button.click();
			@SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, 5);
			System.out.println(hold_on_message.getText().trim());
			ExtentTest test1 = test.createNode("Verifying Processing Message");
			if (hold_on_message.getText().trim()
					.equals("Reloading Page | Please wait until the process completes...")) {
				test1.pass("Processing message is displayed correctly");
			} else {
				test1.fail("Processing message is not correctly displayed");
			}

			Thread.sleep(5000);
			WebElement ref = driver.findElement(By.xpath("//input[@id='custpage_refresh']"));
			System.out.println(ref.isDisplayed());

			refresh_until_process();
			String first_date = "";
			String second_date = "";
			String first_emails = "";
			String second_emails = "";
			if (testcase.equals("one invoice to multiple email ids")) {
				driver.navigate().to(first_customer_url);
				communication_tab.click();
				first_emails = email_ids_in_customer_record.get(0).getText().trim();
				System.out.println(first_emails);
				ExtentTest test2 = test.createNode("Sending Email With Template");
				ExtentTest test3 = test.createNode("Verifying Customer Statement and content of customer statement");
				ExtentTest test5 = test.createNode("Veriyfing whether correct invoice is attached to customer or not");
				ExtentTest test4 = test.createNode("Verifying whether correct Email Template is attached or not");

				String customer_invoice = attachments_in_customer_record.get(0).getText().trim().replaceAll(".pdf", "")
						.replaceAll("Invoice_", "");
				if (customer_invoice.contains(customer_is)) {
					test3.pass("Customer Statement is attached for correct customer");
					System.out.println("Customer Statement is attached for correct customer");
				} else {
					test3.fail("Customer Statement is not attached for correct customer");
					System.out.println("Customer Statement is not attached for correct customer");
				}
				if (customer_invoice.contains(invoice_nr)) {
					test5.pass("Correct invoice is sent to the customer");
					System.out.println("Correct invoice is sent to the customer");
				} else {
					test5.fail("Correct invoice is not sent to the customer");
					System.out.println("Correct invoice is not sent to the customer");

				}
				if (template_in_customer_record.get(0).getText()
						.equals(correct_template("Invoice Email Template").trim())) {
					test4.pass("Selected Email Template is matched with received Email Template");
				} else {
					test4.fail("Selected Email Templated is not matched with received Email Template");
				}
				if (!first_emails.equals("")) {
					test2.pass("Email is sending by selecting valid template");
				}
				if (first_emails.replace("; ", ",").equals(email_ids.trim())) {
					test.pass("One invoice is sent to multiple email id's");
					System.out.println("One invoice is sent to multiple email id's");
				} else {
					test.fail("One invoice is not sent to multiple email id's");
					System.out.println("One invoice is not sent to multiple email id's");
				}
			} else {
				if (first_customer_url.equals(second_customer_url)) {

					driver.navigate().to(first_customer_url);
					communication_tab.click();
					first_date = dates_in_customer_record.get(0).getText().trim();
					System.out.println("first date: " + first_date);
					second_date = dates_in_customer_record.get(1).getText().trim();
					System.out.println("second date: " + second_date);
					first_emails = email_ids_in_customer_record.get(0).getText().trim();
					System.out.println("first email: " + first_emails);
					second_emails = email_ids_in_customer_record.get(1).getText();
					System.out.println("second emails: " + second_emails);
					if (first_date.equals(second_date) && first_emails.replace("; ", ",").equals(email2)
							&& second_emails.replace("; ", ",").equals(email_ids)) {
						test.pass("Multiple invoices are sent to multiple email ids");
						System.out.println("Multiple invoices are sent to multiple email id's");

					}

				} else {
					driver.navigate().to(first_customer_url);
					communication_tab.click();
					first_date = dates_in_customer_record.get(0).getText().trim();
					System.out.println("first date: " + first_date);

					first_emails = email_ids_in_customer_record.get(0).getText().trim();
					System.out.println("first email: " + first_emails);
					driver.navigate().to(second_customer_url);

					communication_tab.click();
					second_date = dates_in_customer_record.get(0).getText().trim();
					System.out.println("second date: " + second_date);

					second_emails = email_ids_in_customer_record.get(0).getText();
					System.out.println("second emails: " + second_emails);
					if (first_date.equals(second_date) && first_emails.replace("; ", ",").equals(email_ids)
							&& second_emails.replace("; ", ",").equals(email2)) {
						test.pass("Multiple invoices are sent to multiple email ids");
						System.out.println("Multiple invoices are sent to multiple email id's");

					}

				}

			}
		}
	}

	public String date_function(int no_of_days) throws ParseException {

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format1 = new SimpleDateFormat("M/d/yyyy");
		String today_date = format1.format(cal.getTime());
		System.out.println(today_date);
		cal.setTime(format1.parse(today_date));
		cal.add(Calendar.DATE, no_of_days);
		String next_day = format1.format(cal.getTime());
		System.out.println(next_day);
		return next_day;
	}
	
	public void configuration_details(String before, String after, String testcase) throws InterruptedException {
		config_page();
		no_of_days_before_due_date.clear();
		no_of_days_before_due_date.sendKeys(before);
		no_of_days_after_due_date.clear();
		no_of_days_after_due_date.sendKeys(after);
		Thread.sleep(3000);

		if (driver.findElement(By.xpath("//span[@id='custpage_mutliattach_fs']")).getAttribute("class")
				.equals("checkbox_unck")) {
			driver.findElement(By.xpath("//input[@name='custpage_mutliattach_send']//following-sibling::img")).click();
		}
		if (testcase.trim().equals(
				"Verifying  Multi Attach functionality in Automated Emails send  by unchecking Multi Attach checkbox")) {
			if (driver.findElement(By.xpath("//span[@id='custpage_mutliattach_fs']")).getAttribute("class")
					.equals("checkbox_ck")) {
				driver.findElement(By.xpath("//input[@name='custpage_mutliattach_send']//following-sibling::img"))
						.click();
			} else {
				System.out.println("already unchecked");
			}

		}
		before_email_arrow.click();
		for (WebElement template : dropdown_email_after_before) {
			if (template.getText().trim().equals("Invoice Email Template")) {
				template.click();
				break;
			}
		}
		Thread.sleep(7000);
		if (after_email_arrow.isDisplayed())
			after_email_arrow.click();
		for (WebElement template : dropdown_email_after_before) {
			if (template.getText().trim().equals("CI Dunning - Level 1")) {
				template.click();
				break;
			}
		}

		Thread.sleep(3000);
		submit_config.click();
		driver.navigate().back();
	}

	public void script_running() throws InterruptedException {
		Actions action1 = new Actions(driver);
		driver.navigate().to("https://tstdrv939179-rp.app.netsuite.com/app/common/scripting/scriptrecord.nl?id=1355");
		script_edit.click();
		action1.moveToElement(edit_expand).build().perform();
		save_and_execute.click();
		if (isAlertPresent_() == true) {
			Alert alert1 = driver.switchTo().alert();
			alert1.accept();
		}
		Thread.sleep(5000);
		for (;;) {
			driver.navigate().refresh();
			if (script_status.get(0).getText().equals("Complete"))
				break;
		}
		Thread.sleep(5000);
	}

	public void editing_search(String customer, String url, String name, WebElement textarea, WebElement popup, int row)
			throws InterruptedException {
		driver.navigate().to(url);
		driver.findElement(By.xpath("//input[@value='Edit this Search']")).click();
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//td[contains(text(),'" + name + "')]")).click();
		action.moveToElement(driver.findElement(By.xpath("//input[@title='" + name + "']"))).build().perform();
		driver.findElement(By.xpath("//a[@title='Set Description']")).click();
		Thread.sleep(5000);
		driver.switchTo().frame("filter_frame");
		textarea.sendKeys(Keys.CONTROL + "a");
		textarea.sendKeys(Keys.DELETE);
		popup.click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//input[@id='st']")).sendKeys(customer.trim());
		driver.findElement(By.xpath("//input[@id='Search']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='inner_popup_div']//table//tbody//tr[" + row
				+ "]//td//a[contains(text(),'" + customer.trim() + "')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='update']")).click();
		driver.findElement(By.xpath("//input[@id='set']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@id='spn_secondarymultibutton_save']")).click();
	}

	public void auto_email_multi_attach_same(String before, String after, String customer, String no_of_invoices,
			String testcase, String invoices_due_date, ExtentTest test) throws Exception {
		configuration_details("1", "1", testcase);
		editing_search(customer.trim(),
				"https://tstdrv939179-rp.app.netsuite.com/app/common/search/searchresults.nl?searchid=539&whence=",
				"Name", search_text_area, name_popup_list, 2);
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		String[] invoice_urls = new String[Integer.parseInt(no_of_invoices)];
		int k = 0;
		String[] customer_before = new String[Integer.parseInt(no_of_invoices)];
		String[] invoices_before = new String[Integer.parseInt(no_of_invoices)];
		String[] due_date_in_invoice = new String[Integer.parseInt(no_of_invoices)];
		int l = 0;
		for (int i = 0; i < partially_paid_invoices.size(); i++) {
			if (i == Integer.parseInt(no_of_invoices))
				break;
			WebElement open_invoices = partially_paid_invoices.get(i);
			open_invoices.sendKeys(selectLinkOpeninNewTab);
			windowHandle();
			Thread.sleep(2000);
			invoice_urls[k] = driver.getCurrentUrl();
			k = k + 1;
			edit_invoice.click();
			due_date_in_invoice_record.clear();
			if (testcase.trim().equals(
					"Verifying Multi Attach functionality in Automated Emails send before due date for same customer with different invoices having same due dates")) {
				due_date_in_invoice_record.sendKeys(date_function(Integer.parseInt(before)));
			}
			if (testcase.trim().equals(
					"Verifying Multi Attach functionality in Automated Emails send after due date for same customer with different invoices having same due dates")) {
				due_date_in_invoice_record.sendKeys(date_function(Integer.parseInt(after)));

			}

			Thread.sleep(5000);
			save_invoice.click();
			Thread.sleep(2000);
			customer_before[l] = customer_in_invoice.getText().trim();
			invoices_before[l] = invoice_nr_in_invoice.getText().trim();
			due_date_in_invoice[l] = due_date_after_save.getText().trim();
			l = l + 1;
			driver.close();
			driver.switchTo().window(parentWindow);
		}
		try {
			String new_nr = driver.findElement(By.xpath("//h1[@class='uir-record-type']")).getText().trim();
			if (new_nr.equals("Duplicate Number")) {
				driver.findElement(By.xpath("//td[@id='tdbody_submitter']")).click();
			}
		} catch (Exception e) {
			System.out.println("no duplicate");
		}
		script_running();
		String[] after_customers = new String[Integer.parseInt(no_of_invoices)];
		String[] after_invoices = new String[Integer.parseInt(no_of_invoices)];
		String[] email_dates = new String[Integer.parseInt(no_of_invoices)];
		String[] invoices_customer = new String[Integer.parseInt(no_of_invoices)];
		String total_no_of_invoices[] = new String[Integer.parseInt(no_of_invoices)];

		int email_date = 0;
		for (int i = 0; i < invoice_urls.length; i++) {
			driver.navigate().to(invoice_urls[i]);
			Thread.sleep(2000);
			after_customers[i] = customer_in_invoice.getText().trim();
			after_invoices[i] = invoice_nr_in_invoice.getText().trim();
			js.executeScript("arguments[0].scrollIntoView(true);", bulk_email_invoices_tab);
			Thread.sleep(2000);
			bulk_email_invoices_tab.click();
			if (!auto_email_send_date_in_bei.getText().trim().equals("")) {
				email_dates[email_date] = auto_email_send_date_in_bei.getText().trim();
				email_date = email_date + 1;
			}
			total_no_of_invoices[i] = no_of_invoices_in_invoice.getText().trim();
			js.executeScript("window.scrollTo(0,0)");
			Thread.sleep(1000);
			customer_in_invoice.sendKeys(selectLinkOpeninNewTab);
			windowHandle();
			Thread.sleep(1000);
			communication_tab.click();
			invoices_customer[i] = attachments_in_customer_record.get(0).getText().trim().replaceAll(".pdf", "")
					.replaceAll("Invoice_", "");
			driver.close();
			driver.switchTo().window(parentWindow);
			Thread.sleep(2000);
		}

		Set<String> s1 = new HashSet<>(Arrays.asList(after_customers));
		Set<String> s2 = new HashSet<>(Arrays.asList(email_dates));
		Set<String> s3 = new HashSet<>(Arrays.asList(invoices_customer));
		Set<String> s4 = new HashSet<>(Arrays.asList(customer_before));
		Set<String> s5 = new HashSet<>(Arrays.asList(total_no_of_invoices));
		String total_count_of_invoices = null;
		if (s5.size() == 1) {
			total_count_of_invoices = total_no_of_invoices[0];
		}
		String final_before_customer = null;
		String email_send_date = null;
		if (s2.size() == 1) {
			email_send_date = email_dates[0];
		}
		if (s4.size() == 1) {
			final_before_customer = customer_before[0];
		}
		String customer_name = null;
		if (s3.size() == 1 && s1.size() == 1) {
			customer_name = after_customers[0];
			String customer_invoices_name = invoices_customer[0];
			String customer_array[] = customer_invoices_name.split("\n");
			List<String> invoices_customers = new ArrayList<>();
			invoices_customers.addAll(Arrays.asList(after_invoices));
			invoices_customers.add(customer_name);
			System.out.println(invoices_customers);
			System.out.println(Arrays.asList(customer_array));
			char ch = '"';
			if (customer_name.trim().equals(customer.trim())) {
				if (Arrays.asList(customer_array).containsAll(invoices_customers) && s2.size() == 1
						&& email_send_date.equals(date_function(0))
						&& total_count_of_invoices.equals(no_of_invoices.trim())) {
					if (testcase.trim().equals(
							"Verifying Multi Attach functionality in Automated Emails send before due date for same customer with different invoices having same due dates")) {
						test.pass("Before sending auto email, Customer " + ch + final_before_customer + ch
								+ " having invoices  " + ch
								+ Arrays.toString(invoices_before).replace("[", "").replace("]", "") + ch
								+ " has same before due date " + ch + date_function(Integer.parseInt(before)) + ch);

						test.pass("After sending auto email, Auto Email send date for customer " + ch + customer_name
								+ ch + " having invoices " + ch
								+ Arrays.toString(after_invoices).replace("[", "").replace("]", "") + ch
								+ " with same before due date " + ch + date_function(Integer.parseInt(before)) + ch
								+ " is " + ch + email_send_date + ch);

						test.pass(
								"Correct Customer with multiple Invoices are getting attached in the sent auto email");
					}
					if (testcase.trim().equals(
							"Verifying Multi Attach functionality in Automated Emails send after due date for same customer with different invoices having same due dates")) {
						test.pass("Before sending auto email, Customer " + ch + final_before_customer + ch
								+ " having invoices  " + ch
								+ Arrays.toString(invoices_before).replace("[", "").replace("]", "") + ch
								+ " has same after due date " + ch + date_function(Integer.parseInt(after)) + ch);

						test.pass("After sending auto email, Auto Email send date for customer " + ch + customer_name
								+ ch + " having invoices " + ch
								+ Arrays.toString(after_invoices).replace("[", "").replace("]", "") + ch
								+ " with same after due date " + ch + date_function(Integer.parseInt(after)) + ch
								+ " is " + ch + email_send_date + ch);

						test.pass(
								"Correct Customer with multiple Invoices are getting attached in the sent auto email");

					}

				}

			}

			else {
				test.fail("Multi Email is not sent");

			}

		}

	}

	public void auto_email_multi_attach_different(String before, String after, String customer, String no_of_invoices,
			String testcase, String invoices_due_date, ExtentTest test) throws Exception {

		configuration_details("1", "1", testcase);
		Thread.sleep(5000);
		editing_search(customer.trim(),
				"https://tstdrv939179-rp.app.netsuite.com/app/common/search/searchresults.nl?searchid=539&whence=",
				"Name", search_text_area, name_popup_list, 2);
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		String[] invoice_urls = new String[Integer.parseInt(no_of_invoices)];
		int k = 0;
		String[] customer_before = new String[Integer.parseInt(no_of_invoices)];
		String[] invoices_before = new String[Integer.parseInt(no_of_invoices)];
		String[] before_array = before.trim().split(",");
		String[] after_array = after.trim().split(",");
		String[] due_date_in_invoice = new String[Integer.parseInt(no_of_invoices)];
		int l = 0;
		for (int i = 0; i < partially_paid_invoices.size(); i++) {
			if (i == Integer.parseInt(no_of_invoices))
				break;
			WebElement open_invoices = partially_paid_invoices.get(i);
			open_invoices.sendKeys(selectLinkOpeninNewTab);
			windowHandle();
			Thread.sleep(2000);
			invoice_urls[k] = driver.getCurrentUrl();
			k = k + 1;
			edit_invoice.click();
			due_date_in_invoice_record.clear();
			if (testcase.trim().equals(
					"Verifying Multi Attach functionality in Automated Emails send before due date for same customer with different invoices having different due dates")) {
				due_date_in_invoice_record.sendKeys(date_function(Integer.parseInt(before_array[i])));
			}
			if (testcase.trim().equals(
					"Verifying Multi Attach functionality in Automated Emails send after due date for same customer with different invoices having different due dates")) {
				due_date_in_invoice_record.sendKeys(date_function(Integer.parseInt(after_array[i])));

			}
			Thread.sleep(5000);
			try {
				save_invoice.click();
				String new_nr = driver.findElement(By.xpath("//h1[@class='uir-record-type']")).getText().trim();
				if (new_nr.equals("Duplicate Number")) {
					driver.findElement(By.xpath("//td[@id='tdbody_submitter']")).click();
				}
			} catch (Exception e) {
				System.out.println("no duplicate");
			}
			Thread.sleep(2000);
			customer_before[l] = customer_in_invoice.getText().trim();
			invoices_before[l] = invoice_nr_in_invoice.getText().trim();
			due_date_in_invoice[l] = due_date_after_save.getText().trim();
			l = l + 1;
			driver.close();
			driver.switchTo().window(parentWindow);
		}

		script_running();
		int emails_count = 0;
		int due_count = 0;
		List<String> emailed_invoices = new ArrayList<String>();
		List<String> not_emailed_invoices = new ArrayList<String>();
		List<String> total_count_of_emails = new ArrayList<String>();
		List<String> emailed_due_dates = new ArrayList<String>();
		List<String> emailed_customer = new ArrayList<String>();
		List<String> auto_email_send_dates = new ArrayList<String>();
		for (int i = 0; i < invoice_urls.length; i++) {
			driver.navigate().to(invoice_urls[i]);
			Thread.sleep(2000);
			if (testcase.trim().equals(
					"Verifying Multi Attach functionality in Automated Emails send before due date for same customer with different invoices having different due dates")) {
				if (due_date_after_save.getText().trim().equals(date_function(1))) {
					due_count = due_count + 1;
				}
			}
			if (testcase.trim().equals(
					"Verifying Multi Attach functionality in Automated Emails send after due date for same customer with different invoices having different due dates")) {
				if (due_date_after_save.getText().trim().equals(date_function(-1))) {
					due_count = due_count + 1;
				}
			}
			js.executeScript("arguments[0].scrollIntoView(true);", bulk_email_invoices_tab);
			Thread.sleep(2000);
			bulk_email_invoices_tab.click();
			Thread.sleep(2000);
			if (!auto_email_send_date_in_bei.getText().trim().equals("")) {
				auto_email_send_dates.add(auto_email_send_date_in_bei.getText().trim());
				emails_count = emails_count + 1;
			}
			if (!auto_email_send_date_in_bei.getText().trim().equals("")) {
				total_count_of_emails.add(no_of_invoices_in_invoice.getText().trim());
			}
			js.executeScript("window.scrollTo(0,0)");
			if (!auto_email_send_date_in_bei.getText().trim().equals("")) {
				emailed_invoices.add(invoice_nr_in_invoice.getText().trim());
				emailed_due_dates.add(due_date_after_save.getText().trim());
				emailed_customer.add(customer_in_invoice.getText().trim());
			} else {
				not_emailed_invoices.add(invoice_nr_in_invoice.getText().trim());
			}

			Thread.sleep(1000);
		}
		Set<String> customer_set = new HashSet<>(emailed_customer);
		Set<String> auto_email_set = new HashSet<>(auto_email_send_dates);
		String[] auto_email_array = new String[auto_email_set.size()];
		int i = 0;
		for (String x : auto_email_set) {
			auto_email_array[i++] = x;
		}
		char ch = '"';
		if (due_count == emails_count && due_count == total_count_of_emails.size()
				&& due_count == emailed_invoices.size() && customer_set.size() == 1) {

			test.pass("Before sending auto email Customer " + ch + customer + ch + " having Invoices: " + ch
					+ Arrays.toString(invoices_before).replace("[", "").replace("]", "") + ch + " with due dates are "
					+ ch + Arrays.toString(due_date_in_invoice).replace("[", "").replace("]", "") + ch);
			test.pass("After Sending auto email, Auto email send date for customer " + ch + customer + ch
					+ " having invoices : " + ch + emailed_invoices.toString().replace("[", "").replace("]", "") + ch
					+ " with due dates " + ch + emailed_due_dates.toString().replace("[", "").replace("]", "") + ch
					+ " is " + ch + auto_email_array[0] + ch);
			test.pass("Multi Attach Auto Email is sent with invoices having same due dates");
		} else {
			test.fail("Multi Attach Auto Email is not sent with invoices having same due dates");
		}
	}

	public void auto_email_multi_attach_combo(String before, String after, String customer, String no_of_invoices,
			String testcase, String invoices_due_date, ExtentTest test) throws Exception {

		configuration_details("1", "1", testcase);
		Thread.sleep(5000);
		editing_search(customer.trim(),
				"https://tstdrv939179-rp.app.netsuite.com/app/common/search/searchresults.nl?searchid=539&whence=",
				"Name", search_text_area, name_popup_list, 2);
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		String[] invoice_urls = new String[Integer.parseInt(no_of_invoices)];
		int k = 0;
		String[] before_array = before.trim().split(",");
		String[] after_array = after.trim().split(",");
		String[] due_date_in_invoice = new String[Integer.parseInt(no_of_invoices)];
		List<String> invoices_before_due = new ArrayList<String>();
		List<String> invoices_after_due = new ArrayList<String>();
		List<String> customer_list = new ArrayList<String>();
		List<String> due_date_before = new ArrayList<String>();
		List<String> due_date_after = new ArrayList<String>();
		int l = 0;

		for (int i = 0; i < partially_paid_invoices.size(); i++) {
			if (i == Integer.parseInt(no_of_invoices))
				break;
			WebElement open_invoices = partially_paid_invoices.get(i);
			open_invoices.sendKeys(selectLinkOpeninNewTab);
			windowHandle();
			Thread.sleep(2000);
			invoice_urls[k] = driver.getCurrentUrl();
			k = k + 1;
			edit_invoice.click();
			due_date_in_invoice_record.clear();
			due_date_in_invoice_record.sendKeys(date_function(Integer.parseInt(before_array[i])));
			Thread.sleep(5000);
			try {
				save_invoice.click();
				String new_nr = driver.findElement(By.xpath("//h1[@class='uir-record-type']")).getText().trim();
				if (new_nr.equals("Duplicate Number")) {
					driver.findElement(By.xpath("//td[@id='tdbody_submitter']")).click();
				}
			} catch (Exception e) {
				System.out.println("no duplicate");
			}
			Thread.sleep(2000);
			customer_list.add(customer_in_invoice.getText().trim());
			if (due_date_after_save.getText().trim().equals(date_function(-1))) {
				invoices_before_due.add(invoice_nr_in_invoice.getText().trim());
				due_date_before.add(due_date_after_save.getText().trim());
			}
			if (due_date_after_save.getText().trim().equals(date_function(1))) {
				invoices_after_due.add(invoice_nr_in_invoice.getText().trim());
				due_date_after.add(due_date_after_save.getText().trim());

			}
			driver.close();
			driver.switchTo().window(parentWindow);
		}
		script_running();
		Set<String> customer_one = new HashSet<>(customer_list);
		List<String> invoice_before_after = null;
		List<String> invoice_before_after1 = null;
		String auto_email_date = null;
		if (customer_one.size() == 1) {
			driver.navigate().to(invoice_urls[0]);
			js.executeScript("arguments[0].scrollIntoView(true);", bulk_email_invoices_tab);
			Thread.sleep(2000);
			bulk_email_invoices_tab.click();
			Thread.sleep(2000);
			auto_email_date = auto_email_send_date_in_bei.getText().trim();
			js.executeScript("window.scrollTo(0,0)");
			Thread.sleep(2000);
			customer_in_invoice.sendKeys(selectLinkOpeninNewTab);
			windowHandle();
			Thread.sleep(1000);
			communication_tab.click();
			invoice_before_after = new ArrayList<String>(Arrays.asList(attachments_in_customer_record.get(0).getText()
					.trim().replaceAll(".pdf", "").replaceAll("Invoice_", "").split("\n")));
			invoice_before_after1 = new ArrayList<String>(Arrays.asList(attachments_in_customer_record.get(1).getText()
					.trim().replaceAll(".pdf", "").replaceAll("Invoice_", "").split("\n")));
			driver.close();
			driver.switchTo().window(parentWindow);

		}
		invoices_before_due.add(customer);
		invoices_after_due.add(customer);
		char ch = '"';
		System.out.println("invoices from cust record: " + invoice_before_after);
		System.out.println("ivoices from cust record1: " + invoice_before_after1);
		System.out.println("invoices from invoice record before: " + invoices_before_due);
		System.out.println("invoices from invoice record after :" + invoices_after_due);
		if (auto_email_date.equals(date_function(0))) {
			if (invoices_before_due.containsAll(invoice_before_after)
					|| invoices_before_due.containsAll(invoice_before_after1)) {
				if (invoices_after_due.containsAll(invoice_before_after)
						|| invoices_after_due.containsAll(invoice_before_after1)) {
					invoices_before_due.remove(customer);
					System.out.println("invoices from invoice record before: " + invoices_before_due);
					invoices_after_due.remove(customer);
					System.out.println("invoices from invoice record after :" + invoices_after_due);
					invoice_before_after.remove(customer);
					invoice_before_after1.remove(customer);
					test.pass("Invoices for customer " + ch + customer + ch + " having due dates " + ch
							+ due_date_before.toString().replace("[", "").replace("]", "") + ch + " are " + ch
							+ invoices_before_due.toString().replace("[", "").replace("]", "") + ch);
					test.pass("Invoices for customer " + ch + customer + ch + " having due dates " + ch
							+ due_date_after.toString().replace("[", "").replace("]", "") + ch + " are " + ch
							+ invoices_after_due.toString().replace("[", "").replace("]", "") + ch);
					test.pass("Auto Email send date for emails having multi attached invoices " + ch
							+ invoice_before_after.toString().replace("[", "").replace("]", "") + ch + " and " + ch
							+ invoice_before_after1.toString().replace("[", "").replace("]", "") + ch + " is "
							+ auto_email_date);
					test.pass("Invoices with same due dates are multi Attached");
				}
			} else {
				test.fail("Invoices are not multiattached");
			}
		} else {
			test.fail("Auto email is not sent correctly");
		}

	}

	public void auto_email_exclude(String before, String after, String customer, String no_of_invoices, String testcase,
			String invoices_due_date, ExtentTest test) throws Exception {
		configuration_details("1", "1", testcase);
		Thread.sleep(5000);
		editing_search(customer.trim(),
				"https://tstdrv939179-rp.app.netsuite.com/app/common/search/searchresults.nl?searchid=539&whence=",
				"Name", search_text_area, name_popup_list, 2);
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		String[] invoice_urls = new String[Integer.parseInt(no_of_invoices)];
		int k = 0;
		String[] before_array = before.trim().split(",");
		List<String> invoices_before_due = new ArrayList<String>();

		for (int i = 0; i < partially_paid_invoices.size(); i++) {
			if (i == Integer.parseInt(no_of_invoices))
				break;
			WebElement open_invoices = partially_paid_invoices.get(i);
			open_invoices.sendKeys(selectLinkOpeninNewTab);
			windowHandle();
			Thread.sleep(2000);
			invoice_urls[k] = driver.getCurrentUrl();
			k = k + 1;
			edit_invoice.click();
			due_date_in_invoice_record.clear();
			due_date_in_invoice_record.sendKeys(date_function(Integer.parseInt(before_array[i])));
			Thread.sleep(1000);
			// js.executeScript("arguments[0].scrollIntoView(true);",bulk_email_invoices_tab);
			// Thread.sleep(2000);
			bulk_email_invoices_tab.click();
			Thread.sleep(2000);
			exclude_invvoice.click();
			js.executeScript("window.scrollTo(0,0)");
			Thread.sleep(2000);
			try {
				save_invoice.click();
				String new_nr = driver.findElement(By.xpath("//h1[@class='uir-record-type']")).getText().trim();
				if (new_nr.equals("Duplicate Number")) {
					driver.findElement(By.xpath("//td[@id='tdbody_submitter']")).click();
				}
			} catch (Exception e) {
				System.out.println("no duplicate");
			}
			Thread.sleep(2000);
			invoices_before_due.add(invoice_nr_in_invoice.getText().trim());
			driver.close();
			driver.switchTo().window(parentWindow);
			Thread.sleep(1000);
		}
		script_running();
		int auto_email_count = 0;
		String auto_email_send = null;
		for (int i = 0; i < invoice_urls.length; i++) {
			driver.navigate().to(invoice_urls[i]);
			js.executeScript("arguments[0].scrollIntoView(true);", bulk_email_invoices_tab);
			Thread.sleep(2000);
			bulk_email_invoices_tab.click();
			Thread.sleep(2000);
			if (auto_email_send_date_in_bei.getText().trim().equals("")) {
				auto_email_send = auto_email_send_date_in_bei.getText().trim();
				auto_email_count = auto_email_count + 1;
			}
			js.executeScript("window.scrollTo(0,0)");

		}
		char ch = '"';
		if (auto_email_count == Integer.parseInt(no_of_invoices) && auto_email_send.equals("")) {
			test.pass("Auto Email send date for customer " + ch + customer + ch + " having invoices " + ch
					+ invoices_before_due.toString().replace("[", "").replace("]", "") + ch + " is null");
			test.pass("Auto Email is not sent to customers having Excluded invoices");
		} else {
			test.fail("Auto Email is sent to Excluded invoices");
		}
	}

	public void auto_email_uncheck(String before, String after, String customer, String no_of_invoices, String testcase,
			String invoices_due_date, ExtentTest test) throws Exception {
		configuration_details("1", "1", testcase);
		Thread.sleep(5000);
		editing_search(customer.trim(),
				"https://tstdrv939179-rp.app.netsuite.com/app/common/search/searchresults.nl?searchid=539&whence=",
				"Name", search_text_area, name_popup_list, 2);
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		String[] invoice_urls = new String[Integer.parseInt(no_of_invoices)];
		int k = 0;
		String[] before_array = before.trim().split(",");
		String[] after_array = after.trim().split(",");
		String[] due_date_in_invoice = new String[Integer.parseInt(no_of_invoices)];
		List<String> invoices_before_due = new ArrayList<String>();
		List<String> invoices_after_due = new ArrayList<String>();
		List<String> customer_list = new ArrayList<String>();
		List<String> due_date_before = new ArrayList<String>();
		List<String> due_date_after = new ArrayList<String>();
		int l = 0;

		for (int i = 0; i < partially_paid_invoices.size(); i++) {
			if (i == Integer.parseInt(no_of_invoices))
				break;
			WebElement open_invoices = partially_paid_invoices.get(i);
			open_invoices.sendKeys(selectLinkOpeninNewTab);
			windowHandle();
			Thread.sleep(2000);
			invoice_urls[k] = driver.getCurrentUrl();
			k = k + 1;
			edit_invoice.click();
			due_date_in_invoice_record.clear();
			due_date_in_invoice_record.sendKeys(date_function(Integer.parseInt(before_array[i])));
			Thread.sleep(5000);
			try {
				save_invoice.click();
				String new_nr = driver.findElement(By.xpath("//h1[@class='uir-record-type']")).getText().trim();
				if (new_nr.equals("Duplicate Number")) {
					driver.findElement(By.xpath("//td[@id='tdbody_submitter']")).click();
				}
			} catch (Exception e) {
				System.out.println("no duplicate");
			}
			Thread.sleep(2000);
			customer_list.add(customer_in_invoice.getText().trim());
			invoices_before_due.add(invoice_nr_in_invoice.getText().trim());
			driver.close();
			driver.switchTo().window(parentWindow);
		}
		script_running();
		Set<String> customer_one = new HashSet<>(customer_list);
		List<String> invoice_before_after = null;
		List<String> invoice_before_after1 = null;
		String auto_email_date = null;
		if (customer_one.size() == 1) {

			driver.navigate().to(invoice_urls[0]);
			js.executeScript("arguments[0].scrollIntoView(true);", bulk_email_invoices_tab);
			Thread.sleep(2000);
			bulk_email_invoices_tab.click();
			Thread.sleep(2000);
			auto_email_date = auto_email_send_date_in_bei.getText().trim();
			js.executeScript("window.scrollTo(0,0)");
			Thread.sleep(2000);
			customer_in_invoice.sendKeys(selectLinkOpeninNewTab);
			windowHandle();
			Thread.sleep(1000);
			communication_tab.click();
			invoice_before_after = new ArrayList<String>(Arrays.asList(attachments_in_customer_record.get(0).getText()
					.trim().replaceAll(".pdf", "").replaceAll("Invoice_", "").split("\n")));
			invoice_before_after1 = new ArrayList<String>(Arrays.asList(attachments_in_customer_record.get(1).getText()
					.trim().replaceAll(".pdf", "").replaceAll("Invoice_", "").split("\n")));
			driver.close();
			driver.switchTo().window(parentWindow);

		}

		invoices_before_due.add(customer);
		char ch = '"';
		if (auto_email_date.equals(date_function(0))) {
			if (invoices_before_due.equals(invoice_before_after)
					|| invoices_before_due.equals((invoice_before_after1))) {
				test.fail("Invoices with same due dates are multi Attached when multi attach checkbox is unchecked");
			} else {
				test.pass("Auto Email send date for customer " + ch + customer + ch + " having invoice " + ch
						+ invoice_before_after.get(0) + ch + " is " + auto_email_date);
				test.pass("Auto Email send date for customer " + ch + customer + ch + " having invoice " + ch
						+ invoice_before_after1.get(0) + ch + " is " + auto_email_date);
				test.pass(
						"Invoices with same due dates are not getting multi Attached when multi attach checkbox is unchecked");
			}
		} else {
			test.fail("Auto email is not sent correctly");
		}

	}

	public String correct_template(String template_name) {
		String template = null;
		if (template_name.trim().equals("Invoice Email Template")) {
			template = "Invoice Copy";
		}
		return template;
	}
	public String dunning_email_template1(int dunning_value) {
		String template = null;
		if (dunning_value == 1) {
			template = "Your Invoice (#) is due on";
		}
		if (dunning_value == 2) {
			template = "Invoice 60 days overdue";
		}
		if (dunning_value == 3) {
			template = "Invoice 90 days overdue";
		}
		if (dunning_value == 4) {
			template = "IMMEDIATE ACTION REQUIRED: Your Invoice (#) is past due";
		}
		return template;
	}
	public String dunning_email_template(int dunning_value) {
		String template = null;
		if (dunning_value == 0) {
			template = "Your Invoice (#) is due on";
		}
		if (dunning_value == 1) {
			template = "Invoice 60 days overdue";
		}
		if (dunning_value == 2) {
			template = "Invoice 90 days overdue";
		}
		if (dunning_value == 3) {
			template = "IMMEDIATE ACTION REQUIRED: Your Invoice (#) is past due";
		}
		if (dunning_value >= 4) {
		template = "IMMEDIATE ACTION REQUIRED: Your Invoice (#) is past due";
	}

		return template;

	}

	public void auto_email_dunning(String before, String after, String customer, String no_of_invoices, String testcase,
			String invoices_due_date, ExtentTest test) throws Exception {
		configuration_details("1", "1", testcase);
		String customer_array[] = customer.trim().split(",");
		String invoices_array[] = no_of_invoices.trim().split(",");
		List<String> first_customer_urls = new ArrayList<String>();
		List<String> second_customer_urls = new ArrayList<String>();
		List<String> invoice_first_customer = new ArrayList<String>();
		List<String> invoice_second_customer = new ArrayList<String>();
		List<Integer> dunning_field_values1 = new ArrayList<Integer>();
		List<Integer> dunning_field_values2 = new ArrayList<Integer>();
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		for (int i = 0; i < customer_array.length; i++) {
			editing_search(customer_array[i].trim(),
					"https://tstdrv939179-rp.app.netsuite.com/app/common/search/searchresults.nl?searchid=539&whence=",
					"Name", search_text_area, name_popup_list, 2);
			for (int j = 0; j < Integer.parseInt(invoices_array[i]); j++) {

				WebElement open_invoices = partially_paid_invoices.get(j);
				open_invoices.sendKeys(selectLinkOpeninNewTab);
				windowHandle();
				Thread.sleep(2000);
				if (i == 0) {
					first_customer_urls.add(driver.getCurrentUrl());
					invoice_first_customer.add(invoice_nr_in_invoice.getText().trim());
					bulk_email_invoices_tab.click();
					Thread.sleep(1000);
					if (!dunning_field_value.getText().trim().equals("")) {
						dunning_field_values1.add(Integer.parseInt(dunning_field_value.getText().trim()));
					} else {
						dunning_field_values1.add(0);

					}
				}
				if (i == 1) {
					second_customer_urls.add(driver.getCurrentUrl());
					invoice_second_customer.add(invoice_nr_in_invoice.getText().trim());
					bulk_email_invoices_tab.click();
					Thread.sleep(1000);
					if (!dunning_field_value.getText().trim().equals("")) {
						dunning_field_values2.add(Integer.parseInt(dunning_field_value.getText().trim()));
					} else {
						dunning_field_values2.add(0);
					}
				}
				driver.close();
				driver.switchTo().window(parentWindow);
				Thread.sleep(2000);
			}
		}
		Thread.sleep(2000);
		System.out.println("first customer list values are :" + invoice_first_customer);
		System.out.println("second customer list values are " + invoice_second_customer);
		System.out.println("first customer dunning values are: " + dunning_field_values1);
		System.out.println("second customer dunning values are: " + dunning_field_values2);
		script_running();
		String template1 = null;
		String template2 = null;
		List<String> invoices_in_customer_record1 = null;
		List<String> invoices_in_customer_record2 = null;
		ExtentTest test1 = test.createNode("Same Customer with invoices having same dunning levels");
		ExtentTest test2 = test.createNode("Same Customer with invoices having different dunning levels");
		driver.navigate().to(first_customer_urls.get(0));
		customer_in_invoice.sendKeys(selectLinkOpeninNewTab);
		windowHandle();
		communication_tab.click();
		Thread.sleep(1000);
		template1 = template_in_customer_record.get(0).getText().trim();
		invoices_in_customer_record1 = new ArrayList<String>(Arrays.asList(attachments_in_customer_record.get(0)
				.getText().trim().replaceAll(".pdf", "").replaceAll("Invoice_", "").split("\n")));
		driver.close();
		driver.switchTo().window(parentWindow);
		driver.navigate().to(second_customer_urls.get(0));
		customer_in_invoice.sendKeys(selectLinkOpeninNewTab);
		windowHandle();
		communication_tab.click();
		Thread.sleep(1000);
		template2 = template_in_customer_record.get(0).getText().trim();
		invoices_in_customer_record2 = new ArrayList<String>(Arrays.asList(attachments_in_customer_record.get(0)
				.getText().trim().replaceAll(".pdf", "").replaceAll("Invoice_", "").split("\n")));
		driver.close();
		driver.switchTo().window(parentWindow);
		Thread.sleep(1000);
		System.out.println(invoices_in_customer_record1);
		System.out.println(invoices_in_customer_record2);
		invoices_in_customer_record1.remove(customer_array[0].trim());
		invoices_in_customer_record2.remove(customer_array[1].trim());
		System.out.println("after removing");
		System.out.println(invoices_in_customer_record1);
		System.out.println(invoices_in_customer_record2);
		int max1 = dunning_field_values1.get(0);
		int max2 = Collections.max(dunning_field_values2);
		String template1_from_cust = dunning_email_template(max1);
		String template2_from_cust = dunning_email_template(max2);
		char ch = '"';
		if (template1.equals(template1_from_cust) && invoice_first_customer.equals(invoices_in_customer_record1)) {
			test1.pass("Email Template attached for customer " + ch + customer_array[0] + ch + " having invoices " + ch
					+ invoices_in_customer_record1.toString().replace("[", "").replace("]", "").trim() + ch
					+ " with dunning levels " + ch
					+ dunning_field_values1.toString().replace("[", "").replace("]", "").trim() + ch + " is " + ch
					+ template1 + ch);
			test1.pass("Invoices getting sent with the email template corresponding to the dunning levels");

		} else {
			test1.fail("Invoices are not getting sent with the email template corresponding to the dunning levels");
		}
		if (template2.equals(template2_from_cust) && invoice_second_customer.equals(invoices_in_customer_record2)) {
			test2.pass("Email Template attached for customer " + ch + customer_array[1] + ch + " having invoices " + ch
					+ invoices_in_customer_record2.toString().replace("[", "").replace("]", "").trim() + ch
					+ " with dunning levels " + ch
					+ dunning_field_values2.toString().replace("[", "").replace("]", "").trim() + ch + " is " + ch
					+ template2 + ch);
			test2.pass("Invoices getting sent with the email template having higher dunning level");

		} else {
			test2.fail("Invoices are not getting sent with the email template having higher dunning level");
		}

	}
	
	public void dunning_values_functionality(String before, String after, String customer, String testcase,ExtentTest test) throws InterruptedException, NumberFormatException, ParseException
	{
		editing_search(customer.trim(),
				"https://tstdrv939179-rp.app.netsuite.com/app/common/search/searchresults.nl?searchid=539&whence=",
				"Name", search_text_area, name_popup_list, 2);
		for(int i=0;i<1;i++)
		{
			if(i==1)
				break;
			partially_paid_invoices.get(i).click();
			Thread.sleep(1000);
			
		}
		List<String> dunning_values=new ArrayList<String>();
		String url=driver.getCurrentUrl();
		for(int i=0;i<4;i++)
		{
			driver.navigate().to(url);
			Thread.sleep(3000);
			edit_invoice.click();
			due_date_in_invoice_record.clear();
			due_date_in_invoice_record.sendKeys(date_function(Integer.parseInt(after)));
			Thread.sleep(2000);
			bulk_email_invoices_tab.click();
			Thread.sleep(2000);
			WebElement auto=driver.findElement(By.xpath("//input[@id='custbody_tss_bei_sent_date']"));
			auto.click();
			auto.clear();
			js.executeScript("window.scrollTo(0,0)");
			Thread.sleep(2000);
			save_invoice.click();
			Thread.sleep(2000);
			script_running();
			driver.navigate().to(url);
			Thread.sleep(2000);
			bulk_email_invoices_tab.click();
			Thread.sleep(2000);
			dunning_values.add(dunning_field_value.getText().trim());
			if(i==0)
			{
				String dunning_first_value=dunning_values.get(i);
				if(dunning_first_value.equals("1"))
				{
					test.pass("After running script for first time dunning field value is 1");
					js.executeScript("window.scrollTo(0,0)");
					customer_in_invoice.click();
					Thread.sleep(1000);
					communication_tab.click();
					Thread.sleep(2000);
					String template_from_customer=template_in_customer_record.get(0).getText();
					String valid_template=dunning_email_template1(Integer.parseInt(dunning_first_value));
					if(template_from_customer.trim().equals(valid_template.trim()))
					{
						test.pass("Email Templated attached for dunning level 1 is: "+template_from_customer.trim());
	
					}
				}
			}
			if(i==1)
			{
				String dunning_first_value=dunning_values.get(i);
				if(dunning_first_value.equals("2"))
				{
					test.pass("After running script for second time dunning field value is : 2");
					js.executeScript("window.scrollTo(0,0)");
					customer_in_invoice.click();
					Thread.sleep(1000);
					communication_tab.click();
					String template_from_customer=template_in_customer_record.get(0).getText();
					String valid_template=dunning_email_template1(Integer.parseInt(dunning_first_value));
					if(template_from_customer.trim().equals(valid_template.trim()))
					{
						test.pass("Email Templated attached for dunning level 2 is: "+template_from_customer.trim());
					}
				}
			}
			if(i==2)
			{
				String dunning_first_value=dunning_values.get(i);
				if(dunning_first_value.equals("3"))
				{
					test.pass("After running script for third time dunning field value is : 3");
					js.executeScript("window.scrollTo(0,0)");
					customer_in_invoice.click();
					Thread.sleep(1000);
					communication_tab.click();
					String template_from_customer=template_in_customer_record.get(0).getText();
					String valid_template=dunning_email_template1(Integer.parseInt(dunning_first_value));
					if(template_from_customer.trim().equals(valid_template.trim()))
					{
						test.pass("Email Templated attached for dunning level 3 is: "+template_from_customer.trim());
					}
				}
			}
			if(i==3)
			{
				String dunning_first_value=dunning_values.get(i);
				if(dunning_first_value.equals("4"))
				{
					test.pass("After running script for fourth time dunning field value is : 4");
					js.executeScript("window.scrollTo(0,0)");
					customer_in_invoice.click();
					Thread.sleep(1000);
					communication_tab.click();
					String template_from_customer=template_in_customer_record.get(0).getText();
					String valid_template=dunning_email_template1(Integer.parseInt(dunning_first_value));
					if(template_from_customer.trim().equals(valid_template.trim()))
					{
						test.pass("Email Templated attached for dunning level 4 is: "+template_from_customer.trim());
					}
				}
			}
			

			
			
		}
		
		
	}
	

}