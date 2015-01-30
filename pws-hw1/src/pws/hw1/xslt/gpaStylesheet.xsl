<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="@* | node()">
        <xsl:copy>
            <xsl:apply-templates select="@* | node()"/>
        </xsl:copy>
    </xsl:template>

    <xsl:template match="education">
        <xsl:copy-of select="."/>
        <xsl:element name="GPA">
            <xsl:variable name="totalGrade" select="sum(/profile/education/academicRecord/courses/grade)" />
            <xsl:variable name="totalCredits" select="sum(/profile/education/academicRecord/courses/credits)" />
            <xsl:value-of select="($totalGrade) div ($totalCredits)"/>
        </xsl:element>
    </xsl:template>
<!--    <xsl:template match="@*|node()">
        <xsl:copy>
            <xsl:apply-templates select="@*|node()"/>
        </xsl:copy>
    </xsl:template>
    
    <xsl:template match="profile">
        <list>
            <xsl:apply-templates select="@* | *"/>
            <xsl:element name="GPA">
                <xsl:variable name="totalGrade" select="sum(/profile/education/academicRecord/courses/grade)" />
                <xsl:variable name="totalCredits" select="sum(/profile/education/academicRecord/courses/credits)" />
                <xsl:value-of select="($totalGrade) div ($totalCredits)"/>
            </xsl:element>
        </list>
    </xsl:template>-->
</xsl:stylesheet>
