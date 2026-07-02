import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

public class SDOLigaoCityDivision {
    private static final Color NAVY = new Color(18, 19, 76);
    private static final Color BLUE = new Color(37, 99, 170);
    private static final Color GREEN = new Color(31, 122, 83);
    private static final Color GOLD = new Color(234, 183, 30);
    private static final Color RED = new Color(184, 64, 64);
    private static final Color PAGE = new Color(245, 247, 250);
    private static final Color TEXT = new Color(10, 82, 179);
    private static final Color MUTED = new Color(91, 101, 116);
    private static final Color BORDER = new Color(219, 226, 235);
    private static final String LOGO_PATH = "assets/sdo-ligao-logo.png";
    private static JTabbedPane dashboardTabs;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SDOLigaoCityDivision::createPortal);
    }

    private static void createPortal() {
        setSystemLookAndFeel();

        JFrame frame = new JFrame("SDO Ligao City Division - Finance Management Portal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1100, 760));
        frame.setLocationRelativeTo(null);

        JPanel page = new JPanel(new BorderLayout());
        page.setBackground(PAGE);
        page.add(buildHeader(), BorderLayout.NORTH);
        page.add(buildMainContent(), BorderLayout.CENTER);
        page.add(buildFooter(), BorderLayout.SOUTH);

        frame.setContentPane(page);
        frame.pack();
        frame.setVisible(true);
    }

    private static JPanel buildHeader() {
        JPanel header = new JPanel(new BorderLayout(24, 0));
        header.setBackground(Color.WHITE);
        header.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, BORDER),
                BorderFactory.createEmptyBorder(20, 34, 20, 34)
        ));

        JPanel brand = new JPanel(new BorderLayout(16, 0));
        brand.setOpaque(false);

        JLabel logo = new JLabel(loadLogoIcon(), SwingConstants.CENTER);
        logo.setPreferredSize(new Dimension(74, 74));

        JPanel titleBlock = new JPanel(new GridLayout(2, 1, 0, 4));
        titleBlock.setOpaque(false);

        JLabel title = new JLabel("SDO Ligao City Division Finance Management Portal");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(NAVY);

        JLabel agency = new JLabel("Department of Education - Division of Ligao City");
        agency.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        agency.setForeground(MUTED);

        titleBlock.add(title);
        titleBlock.add(agency);
        brand.add(logo, BorderLayout.WEST);
        brand.add(titleBlock, BorderLayout.CENTER);

        header.add(brand, BorderLayout.WEST);
        return header;
    }

    private static JPanel buildMainContent() {
        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(PAGE);

        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(PAGE);
        main.add(buildHeroSection(), BorderLayout.NORTH);
        main.add(buildDashboardTabs(), BorderLayout.CENTER);

        content.add(main, BorderLayout.CENTER);
        content.add(buildRightNavigationBar(), BorderLayout.EAST);
        return content;
    }

    private static JPanel buildRightNavigationBar() {
        JPanel sideNav = new JPanel(new BorderLayout(0, 14));
        sideNav.setBackground(Color.WHITE);
        sideNav.setPreferredSize(new Dimension(245, 0));
        sideNav.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 1, 0, 0, BORDER),
                BorderFactory.createEmptyBorder(24, 18, 24, 18)
        ));

        JLabel title = new JLabel("Navigation");
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setForeground(NAVY);

        JPanel links = new JPanel(new GridLayout(3, 1, 0, 12));
        links.setOpaque(false);
        links.add(navigationButton("School Heads - MOOE Tracker", 0, false));
        links.add(navigationButton("BAC - Bidding Status/Tracking", 1, false));
        links.add(navigationButton("Personnel - Remittance & Payroll", 2, false));

        JLabel note = new JLabel("<html><body style='width: 190px'>Open checklist pages or switch dashboard views.</body></html>");
        note.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        note.setForeground(MUTED);

        sideNav.add(title, BorderLayout.NORTH);
        sideNav.add(links, BorderLayout.CENTER);
        sideNav.add(note, BorderLayout.SOUTH);
        return sideNav;
    }

    private static JPanel buildHeroSection() {
        JPanel hero = new JPanel(new GridBagLayout());
        hero.setBackground(NAVY);
        hero.setBorder(BorderFactory.createEmptyBorder(30, 34, 30, 34));

        GridBagConstraints left = new GridBagConstraints();
        left.gridx = 0;
        left.gridy = 0;
        left.weightx = 1;
        left.fill = GridBagConstraints.BOTH;
        left.anchor = GridBagConstraints.WEST;

        JPanel copy = new JPanel(new GridLayout(3, 1, 0, 8));
        copy.setOpaque(false);

        JLabel eyebrow = new JLabel("Finance Management Portal");
        eyebrow.setFont(new Font("Segoe UI", Font.BOLD, 14));
        eyebrow.setForeground(GOLD);

        JLabel heading = new JLabel("Empowering Ligao’s Educators with Fast, Transparent Finance");
        heading.setFont(new Font("Segoe UI", Font.BOLD, 27));
        heading.setForeground(Color.WHITE);

        JLabel subheading = new JLabel("Your all-in-one gateway for MOOE tracking, Digital Procurement, Payroll & Remittances updates");
        subheading.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        subheading.setForeground(new Color(222, 231, 245));

        copy.add(eyebrow);
        copy.add(heading);
        copy.add(subheading);
        hero.add(copy, left);

        GridBagConstraints right = new GridBagConstraints();
        right.gridx = 1;
        right.gridy = 0;
        right.weightx = 0;
        right.fill = GridBagConstraints.NONE;
        right.anchor = GridBagConstraints.EAST;
        right.insets = new Insets(0, 26, 0, 0);
        hero.add(buildInputPanel(), right);

        return hero;
    }

    private static JPanel buildInputPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(205, 215, 230)),
                BorderFactory.createEmptyBorder(18, 18, 18, 18)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 8, 0);

        JLabel title = new JLabel("Portal Lookup");
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setForeground(NAVY);
        panel.add(title, gbc);

        gbc.gridy = 1;
        panel.add(inputLabel("User / Office"), gbc);

        gbc.gridy = 2;
        panel.add(textField("Enter school, unit, or employee name"), gbc);

        gbc.gridy = 3;
        panel.add(inputLabel("Dashboard"), gbc);

        gbc.gridy = 4;
        JComboBox<String> dashboardChoice = new JComboBox<>(new String[]{"School Heads - MOOE Tracker", "BAC - Bidding Status/Tracking", "Personnel - Remittance & Payroll"});
        dashboardChoice.addActionListener(event -> navigateToTab(dashboardChoice.getSelectedIndex()));
        panel.add(dashboardChoice, gbc);

        gbc.gridy = 5;
        panel.add(inputLabel("Reference No."), gbc);

        gbc.gridy = 6;
        panel.add(textField("PR, DV, ORS, payroll, or remittance no."), gbc);

        gbc.gridy = 7;
        gbc.insets = new Insets(8, 0, 0, 0);
        JPanel buttons = new JPanel(new GridLayout(1, 2, 10, 0));
        buttons.setOpaque(false);
        JButton search = actionButton("Search", GOLD, new Color(28, 34, 42));
        search.addActionListener(event -> navigateToTab(dashboardChoice.getSelectedIndex()));
        buttons.add(search);
        buttons.add(actionButton("Clear", new Color(232, 238, 247), NAVY));
        panel.add(buttons, gbc);

        return panel;
    }

    private static JTabbedPane buildDashboardTabs() {
        dashboardTabs = new JTabbedPane();
        dashboardTabs.setFont(new Font("Segoe UI", Font.BOLD, 14));
        dashboardTabs.setBackground(PAGE);
        dashboardTabs.addTab("School Heads - MOOE Tracker", schoolHeadsDashboard());
        dashboardTabs.addTab("BAC - Bidding Status/Tracking", bacDashboard());
        dashboardTabs.addTab("Personnel - Remittance & Payroll", personnelDashboard());
        return dashboardTabs;
    }

    private static JPanel schoolHeadsDashboard() {
        JPanel dashboard = dashboardShell("School Heads - MOOE Tracker", "Liquidation monitoring and MOOE utilization tracking for schools.");

        JPanel metrics = new JPanel(new GridLayout(1, 4, 16, 0));
        metrics.setOpaque(false);
        metrics.add(metricCard("MOOE Released", "P 4.82M", "Current quarter allocation", BLUE));
        metrics.add(metricCard("Liquidated", "P 3.76M", "78% of released funds", GREEN));
        metrics.add(metricCard("For Liquidation", "P 1.06M", "Due within reporting period", GOLD));
        metrics.add(metricCard("Overdue Reports", "6", "Schools requiring follow-up", RED));

        dashboard.add(metrics, constraints(1, 0, 0));

        String[] columns = {"School", "MOOE Allocation", "Liquidated", "Balance", "Liquidation Status"};
        Object[][] rows = {
                {"Ligao West Central School", "P 620,000", "P 510,000", "P 110,000", "For review"},
                {"Tastas Elementary School", "P 410,000", "P 395,000", "P 15,000", "Updated"},
                {"Paulba National High School", "P 780,000", "P 610,000", "P 170,000", "Pending documents"},
                {"Tinago Elementary School", "P 350,000", "P 290,000", "P 60,000", "For submission"},
                {"Ligao National High School", "P 1,200,000", "P 980,000", "P 220,000", "For review"}
        };
        dashboard.add(liquidationChecklistPanel(), constraints(2, 18, 0));
        dashboard.add(tablePanel("MOOE Tracker and Liquidation Status", columns, rows), constraints(3, 18, 1));

        return dashboard;
    }

    private static JPanel bacDashboard() {
        JPanel dashboard = dashboardShell("BAC - Bidding Status/Tracking", "Procurement plan tracking for requests, bidding milestones, and award status.");

        JPanel metrics = new JPanel(new GridLayout(1, 4, 16, 0));
        metrics.setOpaque(false);
        metrics.add(metricCard("APP Items", "42", "Annual procurement entries", BLUE));
        metrics.add(metricCard("For Posting", "8", "Items for PhilGEPS or bulletin", GOLD));
        metrics.add(metricCard("Under Evaluation", "11", "Ongoing BAC review", GREEN));
        metrics.add(metricCard("Delayed", "3", "Past target procurement date", RED));

        dashboard.add(metrics, constraints(1, 0, 0));

        String[] columns = {"Procurement Item", "Mode", "Budget", "Target Date", "Bidding Status"};
        Object[][] rows = {
                {"ICT equipment and supplies", "Shopping", "P 420,000", "Jul 18, 2026", "For canvass"},
                {"Office supplies for division units", "Small Value", "P 260,000", "Jul 25, 2026", "For posting"},
                {"School furniture repair materials", "Public Bidding", "P 1,150,000", "Aug 08, 2026", "Under evaluation"},
                {"Janitorial supplies", "Shopping", "P 185,000", "Aug 12, 2026", "For BAC resolution"},
                {"Training meals and venue", "Small Value", "P 315,000", "Aug 20, 2026", "Pending PR"}
        };
        dashboard.add(tablePanel("Bidding Status and Procurement Tracking", columns, rows), constraints(2, 18, 1));

        return dashboard;
    }

    private static JPanel personnelDashboard() {
        JPanel dashboard = dashboardShell("Personnel - Remittance and Payroll Updates", "Remittance updates and payroll status indicators for employees.");

        JPanel metrics = new JPanel(new GridLayout(1, 4, 16, 0));
        metrics.setOpaque(false);
        metrics.add(metricCard("Payroll Batch", "July 2026", "Current processing cycle", BLUE));
        metrics.add(metricCard("Released Payroll", "94%", "Validated and ready", GREEN));
        metrics.add(metricCard("Remittances Due", "5", "Agencies for completion", GOLD));
        metrics.add(metricCard("With Exceptions", "12", "Records needing correction", RED));

        dashboard.add(metrics, constraints(1, 0, 0));

        String[] columns = {"Personnel Group", "Payroll Status", "GSIS", "PhilHealth", "Pag-IBIG", "Remarks"};
        Object[][] rows = {
                {"Teaching Personnel", "Released", "Posted", "Posted", "For confirmation", "Monitor Pag-IBIG acknowledgement"},
                {"Non-Teaching Personnel", "For release", "Submitted", "Submitted", "Submitted", "Awaiting final payroll approval"},
                {"New Appointees", "For validation", "For encoding", "For encoding", "For encoding", "Complete employee records"},
                {"Substitute Teachers", "Processing", "Submitted", "Submitted", "Pending", "Review service dates"},
                {"Separated Personnel", "On hold", "For reconciliation", "Submitted", "Submitted", "Clearances required"}
        };
        dashboard.add(tablePanel("Remittance Updates and Payroll Status Indicators", columns, rows), constraints(2, 18, 1));

        return dashboard;
    }

    private static JPanel dashboardShell(String title, String subtitle) {
        JPanel shell = new JPanel(new GridBagLayout());
        shell.setBackground(PAGE);
        shell.setBorder(BorderFactory.createEmptyBorder(28, 34, 28, 34));

        GridBagConstraints gbc = constraints(0, 0, 0);
        JPanel intro = new JPanel(new BorderLayout(0, 6));
        intro.setOpaque(false);

        JLabel heading = new JLabel(title);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 28));
        heading.setForeground(TEXT);

        JLabel copy = new JLabel(subtitle);
        copy.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        copy.setForeground(MUTED);

        intro.add(heading, BorderLayout.NORTH);
        intro.add(copy, BorderLayout.CENTER);
        shell.add(intro, gbc);
        return shell;
    }

    private static JPanel metricCard(String label, String value, String caption, Color accent) {
        JPanel card = new JPanel(new BorderLayout(0, 8));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(4, 0, 0, 0, accent),
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(BORDER),
                        BorderFactory.createEmptyBorder(18, 18, 18, 18)
                )
        ));

        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        valueLabel.setForeground(TEXT);

        JLabel labelText = new JLabel(label);
        labelText.setFont(new Font("Segoe UI", Font.BOLD, 14));
        labelText.setForeground(accent);

        JLabel captionText = new JLabel("<html><body style='width: 180px'>" + caption + "</body></html>");
        captionText.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        captionText.setForeground(MUTED);

        card.add(labelText, BorderLayout.NORTH);
        card.add(valueLabel, BorderLayout.CENTER);
        card.add(captionText, BorderLayout.SOUTH);
        return card;
    }

    private static JPanel liquidationChecklistPanel() {
        JPanel panel = new JPanel(new BorderLayout(0, 14));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER),
                BorderFactory.createEmptyBorder(18, 18, 18, 18)
        ));

        JLabel title = new JLabel("Liquidation Submission Checklist");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(NAVY);

        JPanel checklist = new JPanel(new GridLayout(2, 3, 12, 10));
        checklist.setOpaque(false);
        checklist.add(checkItem("Approved activity request or authority"));
        checklist.add(checkItem("Statement of expenditures"));
        checklist.add(checkItem("Official receipts and invoices"));
        checklist.add(checkItem("Disbursement voucher and ORS/BURS"));
        checklist.add(checkItem("Attendance, photos, or proof of delivery"));
        checklist.add(checkItem("School head certification and signatures"));

        panel.add(title, BorderLayout.NORTH);
        panel.add(checklist, BorderLayout.CENTER);
        return panel;
    }

    private static JPanel mooeChecklistPanel() {
        JPanel panel = new JPanel(new BorderLayout(0, 14));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER),
                BorderFactory.createEmptyBorder(18, 18, 18, 18)
        ));

        JLabel title = new JLabel("MOOE Checklist by Expense Type");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(NAVY);

        JPanel groups = new JPanel(new GridLayout(2, 2, 14, 14));
        groups.setOpaque(false);
        groups.add(expenseChecklistGroup("Travel Expenses", new String[]{
                "Disbursement Voucher (DV)",
                "Photocopy of checks",
                "Approved itinerary of travel",
                "Certificate of appearance",
                "Travel order or authority to travel"
        }));
        groups.add(expenseChecklistGroup("Office Supplies Expenses", new String[]{
                "Purchase request and purchase order",
                "Canvass or abstract of quotations",
                "Sales invoice or official receipt",
                "Inspection and acceptance report",
                "Requisition and issue slip (RIS)"
        }));
        groups.add(expenseChecklistGroup("Communication Expenses", new String[]{
                "Billing statement",
                "Official receipt or proof of payment",
                "Certification of official use",
                "Approved service request",
                "Monthly utilization summary"
        }));
        groups.add(expenseChecklistGroup("Repairs and Maintenance", new String[]{
                "Approved job order or request",
                "Canvass or quotation documents",
                "Before and after photos",
                "Inspection or completion report",
                "Official receipt or invoice"
        }));

        panel.add(title, BorderLayout.NORTH);
        panel.add(groups, BorderLayout.CENTER);
        return panel;
    }

    private static JPanel expenseChecklistGroup(String title, String[] items) {
        JPanel group = new JPanel(new BorderLayout(0, 10));
        group.setBackground(new Color(248, 250, 253));
        group.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER),
                BorderFactory.createEmptyBorder(14, 14, 14, 14)
        ));

        JLabel heading = new JLabel(title);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 15));
        heading.setForeground(TEXT);

        JPanel list = new JPanel(new GridLayout(items.length, 1, 0, 6));
        list.setOpaque(false);
        for (String item : items) {
            list.add(checkItem(item));
        }

        group.add(heading, BorderLayout.NORTH);
        group.add(list, BorderLayout.CENTER);
        return group;
    }

    private static JCheckBox checkItem(String text) {
        JCheckBox item = new JCheckBox(text);
        item.setOpaque(false);
        item.setForeground(TEXT);
        item.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        item.setFocusPainted(false);
        return item;
    }

    private static ImageIcon loadLogoIcon() {
        ImageIcon source = new ImageIcon(LOGO_PATH);
        Image scaled = source.getImage().getScaledInstance(68, 68, Image.SCALE_SMOOTH);
        return new ImageIcon(scaled);
    }

    private static JLabel inputLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setForeground(MUTED);
        return label;
    }

    private static JTextField textField(String placeholder) {
        JTextField field = new JTextField(placeholder);
        field.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        field.setForeground(MUTED);
        field.setPreferredSize(new Dimension(320, 34));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER),
                BorderFactory.createEmptyBorder(7, 10, 7, 10)
        ));
        return field;
    }

    private static JButton actionButton(String text, Color background, Color foreground) {
        JButton button = new JButton(text);
        button.setBackground(background);
        button.setForeground(foreground);
        button.setFont(new Font("Segoe UI", Font.BOLD, 13));
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(9, 14, 9, 14));
        return button;
    }

    private static JButton navigationButton(String text, int tabIndex, boolean footerStyle) {
        Color background = footerStyle ? new Color(31, 54, 87) : new Color(232, 238, 247);
        Color foreground = footerStyle ? Color.WHITE : NAVY;
        JButton button = actionButton(text, background, foreground);
        if (tabIndex == 0) {
            button.addActionListener(event -> openSchoolHeadsChecklistPage());
        } else {
            button.addActionListener(event -> navigateToTab(tabIndex));
        }
        return button;
    }

    private static void openSchoolHeadsChecklistPage() {
        JFrame checklistFrame = new JFrame("School Heads - Liquidation Checklist");
        checklistFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        checklistFrame.setMinimumSize(new Dimension(980, 720));
        checklistFrame.setLocationRelativeTo(null);

        JPanel page = new JPanel(new BorderLayout());
        page.setBackground(PAGE);
        page.add(buildChecklistPageHeader(), BorderLayout.NORTH);

        JPanel content = new JPanel(new GridBagLayout());
        content.setBackground(PAGE);
        content.setBorder(BorderFactory.createEmptyBorder(26, 34, 26, 34));

        GridBagConstraints gbc = constraints(0, 0, 0);
        content.add(liquidationChecklistPanel(), gbc);

        gbc = constraints(1, 18, 0);
        content.add(mooeChecklistPanel(), gbc);

        String[] trackerColumns = {"School", "MOOE Allocation", "Liquidated", "Balance", "Status"};
        Object[][] trackerRows = {
                {"Ligao West Central School", "P 620,000", "P 510,000", "P 110,000", "For review"},
                {"Tastas Elementary School", "P 410,000", "P 395,000", "P 15,000", "Updated"},
                {"Paulba National High School", "P 780,000", "P 610,000", "P 170,000", "Pending documents"},
                {"Tinago Elementary School", "P 350,000", "P 290,000", "P 60,000", "For submission"}
        };
        gbc = constraints(2, 18, 0);
        content.add(tablePanel("School Heads MOOE Tracker", trackerColumns, trackerRows), gbc);

        String[] columns = {"Description", "Expense Type", "UACS Code", "Checklist Focus"};
        Object[][] rows = {
                {"Official travel for monitoring and meetings", "Travel Expenses", "5020101000", "DV, photocopy of checks, approved itinerary"},
                {"Office supplies and consumables", "Office Supplies Expenses", "5020301000", "RIS, invoices, inspection and acceptance report"},
                {"Internet and communication services", "Communication Expenses", "5020503000", "Billing statement, OR, certification of use"},
                {"Minor repair and maintenance", "Repairs and Maintenance", "5021304000", "Canvass, PO, completion report, photos"},
                {"Training materials and activity needs", "Training Expenses", "5020201000", "Activity design, attendance, receipts, terminal report"}
        };
        gbc = constraints(3, 18, 1);
        content.add(tablePanel("Transaction Checklist Reference", columns, rows), gbc);

        page.add(new JScrollPane(content), BorderLayout.CENTER);
        page.add(buildChecklistPageFooter(), BorderLayout.SOUTH);

        checklistFrame.setContentPane(page);
        checklistFrame.pack();
        checklistFrame.setVisible(true);
    }

    private static JPanel buildChecklistPageHeader() {
        JPanel header = new JPanel(new BorderLayout(16, 0));
        header.setBackground(Color.WHITE);
        header.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, BORDER),
                BorderFactory.createEmptyBorder(18, 28, 18, 28)
        ));

        JLabel logo = new JLabel(loadLogoIcon(), SwingConstants.CENTER);
        logo.setPreferredSize(new Dimension(74, 74));

        JPanel titleBlock = new JPanel(new GridLayout(2, 1, 0, 4));
        titleBlock.setOpaque(false);

        JLabel title = new JLabel("School Heads Liquidation Checklist");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(NAVY);

        JLabel subtitle = new JLabel("Required documents for MOOE liquidation submission");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitle.setForeground(MUTED);

        titleBlock.add(title);
        titleBlock.add(subtitle);
        header.add(logo, BorderLayout.WEST);
        header.add(titleBlock, BorderLayout.CENTER);
        return header;
    }

    private static JPanel buildChecklistPageFooter() {
        JPanel footer = new JPanel(new BorderLayout());
        footer.setBackground(new Color(14, 31, 56));
        footer.setBorder(BorderFactory.createEmptyBorder(14, 28, 14, 28));

        JLabel note = new JLabel("For assistance, contact the SDO Ligao Finance Unit at finance.ligao@deped.gov.ph.");
        note.setForeground(Color.WHITE);
        note.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        footer.add(note, BorderLayout.WEST);
        return footer;
    }

    private static void navigateToTab(int tabIndex) {
        if (dashboardTabs != null && tabIndex >= 0 && tabIndex < dashboardTabs.getTabCount()) {
            dashboardTabs.setSelectedIndex(tabIndex);
        }
    }

    private static JPanel tablePanel(String title, String[] columns, Object[][] rows) {
        JPanel panel = new JPanel(new BorderLayout(0, 14));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER),
                BorderFactory.createEmptyBorder(18, 18, 18, 18)
        ));

        JLabel label = new JLabel(title);
        label.setFont(new Font("Segoe UI", Font.BOLD, 20));
        label.setForeground(NAVY);

        JTable table = new JTable(new DefaultTableModel(rows, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.setRowHeight(32);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        table.getTableHeader().setBackground(new Color(232, 238, 247));
        table.getTableHeader().setForeground(TEXT);
        table.setGridColor(BORDER);
        table.setSelectionBackground(new Color(222, 235, 250));
        table.setSelectionForeground(TEXT);

        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 1; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(center);
        }

        panel.add(label, BorderLayout.NORTH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    private static JPanel buildFooter() {
        JPanel footer = new JPanel(new BorderLayout(18, 8));
        footer.setBackground(new Color(14, 31, 56));
        footer.setBorder(BorderFactory.createEmptyBorder(12, 34, 12, 34));

        JPanel topRow = new JPanel(new BorderLayout(18, 0));
        topRow.setOpaque(false);

        JLabel contacts = new JLabel("Contacts: SDO Ligao City Information Technology & Finance Sections - sdoICT.ligao@deped.gov.ph | Finance - accounting.ligao@deped.gov.ph | Tel. (052) 742-0000");
        contacts.setForeground(Color.WHITE);
        contacts.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        JLabel notices = new JLabel("Notices: Liquidations due every 5th working day | BAC tracking updated weekly | Payroll concerns before cutoff", SwingConstants.RIGHT);
        notices.setForeground(new Color(210, 220, 233));
        notices.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        topRow.add(contacts, BorderLayout.WEST);
        topRow.add(notices, BorderLayout.EAST);

        JPanel bottomRow = new JPanel(new BorderLayout(18, 0));
        bottomRow.setOpaque(false);

        JLabel transparencySeal = new JLabel("DepEd Transparency Seal");
        transparencySeal.setForeground(GOLD);
        transparencySeal.setFont(new Font("Segoe UI", Font.BOLD, 12));

        JLabel copyright = new JLabel("Copyright \u00A9 2026 Department of Education - Schools Division Office of Ligao City. All rights reserved.", SwingConstants.RIGHT);
        copyright.setForeground(new Color(210, 220, 233));
        copyright.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        bottomRow.add(transparencySeal, BorderLayout.WEST);
        bottomRow.add(copyright, BorderLayout.EAST);

        footer.add(topRow, BorderLayout.NORTH);
        footer.add(bottomRow, BorderLayout.SOUTH);

        return footer;
    }

    private static GridBagConstraints constraints(int row, int topInset, double weightY) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 1;
        gbc.weighty = weightY;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(topInset, 0, 0, 0);
        return gbc;
    }

    private static void setSystemLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
            // The default Swing look and feel is acceptable if the system one is unavailable.
        }
    }
}
