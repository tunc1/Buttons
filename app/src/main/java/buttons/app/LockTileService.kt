package buttons.app

import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.service.quicksettings.TileService

class LockTileService:TileService()
{
    override fun onClick()
    {
        super.onClick()
        val devicePolicyManager:DevicePolicyManager=applicationContext.getSystemService(DEVICE_POLICY_SERVICE) as DevicePolicyManager
        val component=ComponentName(this,Admin::class.java)
        if(devicePolicyManager.isAdminActive(component))
            devicePolicyManager.lockNow()
    }
}